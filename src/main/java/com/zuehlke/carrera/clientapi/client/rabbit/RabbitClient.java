package com.zuehlke.carrera.clientapi.client.rabbit;

import com.rabbitmq.client.*;
import com.zuehlke.carrera.clientapi.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitClient implements Client {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitClient.class);
    private final ChannelRegistry registry = new ChannelRegistry();
    private boolean connected = false;
    private Connection connection;

    @Override
    public void connect(String url) {
        if(connected) {
            return;
        }
        try {
            LOG.debug("Starting connection to rabbit on " + url);
            tryConnect(url);
        } catch (IOException | TimeoutException e) {
            LOG.debug("Could not connect rabbit client", e);
            throw new ClientConnectionException("Could not connect rabbit client", e);
        }
    }

    private void tryConnect(String url) throws IOException, TimeoutException {
        ConnectionFactory cf = createConnectionFactory(url);
        createConnection(cf);
    }

    private ConnectionFactory createConnectionFactory(String url) {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost(url);
        return cf;
    }

    private void createConnection(ConnectionFactory cf) throws IOException, TimeoutException {
        connection = cf.newConnection();
        connection.addShutdownListener(cause -> {
            connected = false;
        });
        connected = true;
    }

    @Override
    public void disconnect() {
        LOG.debug("Shutting down rabbit client");
        shutdownRegistry();
        closeConnection();
    }

    private void shutdownRegistry() {
        registry.shutdown();
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (IOException ignored) {
        } finally {
            connection = null;
        }
    }

    @Override
    public void publish(String channelName, String message) {
        try {
            tryPublish(channelName, message);
        } catch (IOException e) {
            throw new PublishException("Could not publish message", e);
        }
    }

    private void tryPublish(String channelName, String message) throws IOException {
        Channel channel = registry.getOrCreate(channelName, connection);
        AMQP.BasicProperties publishProperties = createPublishProperties();
        channel.basicPublish("", channelName, publishProperties, message.getBytes());
    }

    private AMQP.BasicProperties createPublishProperties() {
        return new AMQP.BasicProperties.Builder().expiration("0").build();
    }

    @Override
    public void subscribe(String channelName, MessageReceiver receiver) {
        try {
            trySubscribe(channelName, receiver);
        } catch (IOException e) {
            LOG.debug("Could not subscribe to channel " + channelName, e);
            throw new SubscribeException("Could not subscribe to channel " + channelName, e);
        }
    }

    private void trySubscribe(String channelName, MessageReceiver receiver) throws IOException {
        Channel channel = registry.getOrCreate(channelName, connection);
        Consumer consumer = createDefaultConsumer(channel, receiver);
        channel.basicConsume(channelName, true, consumer);
    }

    private Consumer createDefaultConsumer(final Channel channel, MessageReceiver receiver) {
        return new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    receiver.receive(new String(body, "UTF-8"));
                }
            };
    }
}
