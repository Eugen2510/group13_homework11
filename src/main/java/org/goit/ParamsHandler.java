package org.goit;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ParamsHandler {
    private final HttpServletRequest req;
    private final String parameterName = "timezone";

    public ParamsHandler(HttpServletRequest req) {
        this.req = req;
    }

    public boolean hasParameter(){
        return req.getParameter(parameterName) != null;
    }

    public String getRawParameter(){
        String rawParam = null;
        if (hasParameter()){
            rawParam = URLEncoder
                    .encode(req.getParameter(parameterName), StandardCharsets.UTF_8)
                    .toUpperCase();
        }
        return rawParam;
    }

    protected boolean isParamValid() {
        boolean isValid = false;
        String parameter = getRawParameter();
        if (parameter != null){
            isValid = parameter.matches("(UTC\\+\\d+)" +
                    "|(UTC-\\d+)");
        }
        return isValid;
    }

    public String parseParam(){
        String timezone = "GMT";
        if (isParamValid()) {
            timezone = getRawParameter().replaceAll("UTC", "GMT");
        }
        return timezone;
    }

    public int getHourOffset(){
        int offset = 0;
        String param = parseParam();
        if (isParamValid()){
            String hour =param.replaceAll("GMT", "");
            offset = Integer.parseInt(hour);
        }
        return offset;
    }

}


