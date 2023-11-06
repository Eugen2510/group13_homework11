package org.goit;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/time")
public class TimezoneWebFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        ParamsHandler handler = new ParamsHandler(req);
        int hoursOffset = handler.getHourOffset();
        if ((hoursOffset > -13 && hoursOffset < 15)){
                chain.doFilter(req, res);
        }
        else {
            res.setStatus(401);
        }

    }
}
