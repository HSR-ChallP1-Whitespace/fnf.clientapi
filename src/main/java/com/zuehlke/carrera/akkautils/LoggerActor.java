package com.zuehlke.carrera.akkautils;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * asynchronously writes anything to the configured logger
 */
public class LoggerActor extends UntypedActor {

    private static final Logger myLogger = LoggerFactory.getLogger(LoggerActor.class);

    public static Props props() {
        return Props.create(new Creator<LoggerActor>() {
            private static final long serialVersionUID = 1L;

            @Override
            public LoggerActor create() throws Exception {
                return new LoggerActor();
            }
        });
    }

    @Override
    public void onReceive(Object message) throws Exception {

        if (message instanceof LogMessage) {
            LogMessage logMessage = (LogMessage) message;
            Logger logger = LoggerFactory.getLogger(logMessage.getSource());
            logger.info(((LogMessage) message).getMessage());
        } else {
            myLogger.info(message.toString());
        }
    }
}
