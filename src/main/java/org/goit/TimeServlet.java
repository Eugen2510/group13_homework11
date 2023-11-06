package org.goit;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ParamsHandler handler = new ParamsHandler(req);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 'UTC'X");
        String zone = handler.parseParam();
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(setOutput(dateFormat, zone));
        resp.getWriter().flush();
    }

    private String setOutput(SimpleDateFormat dateFormat, String zone){
        TimeZone timeZone = TimeZone.getTimeZone(zone);
        dateFormat.setTimeZone(timeZone);
        String response = "<h1>" + dateFormat.format(new Date()) + "</h1>";
        return response.replace("Z", "");
    }
}
