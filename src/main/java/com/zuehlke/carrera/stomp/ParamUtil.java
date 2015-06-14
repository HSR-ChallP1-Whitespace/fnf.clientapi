package com.zuehlke.carrera.stomp;

public class ParamUtil {

    /**
     * Parses template URLs like /hello/{variable}/here
     * and replaces variables with the given params.
     *
     *
     * @param templateUrl the url template
     * @param params the params to be used
     * @return the resulting string
     */
    public static String paramUrl(String templateUrl, String... params){
        final String paramPattern = "\\{\\w*\\}";
        for(String param : params){
            templateUrl = templateUrl.replaceFirst(paramPattern, param);
        }
        return templateUrl;
    }
}