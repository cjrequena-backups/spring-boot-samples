package com.sample.filter;

import com.sample.util.SecurityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by crequena on 27/04/2016.
 */
@Component
public class RestSignatureFilter extends OncePerRequestFilter {

    //ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJOamRoWXpsa09HVXRNV0V3TVMwME0yWTNMVGcxT0dZdE1UbGpOMkV5TnpGbE5qVXcifQ.qIpINMwoviUmEtn2pvXI9fILv58dPsMXwNC-3xEvHWU"
    //API_KEY = "8a87bcbd-02ac-49c1-9039-d61907572a2e"
    //PRIVATE KEY= "67ac9d8e-1a01-43f7-858f-19c7a271e650"
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String privateKey = "67ac9d8e-1a01-43f7-858f-19c7a271e650";
        String accessToken = request.getHeader(SecurityUtils.ACCESS_TOKEN_HEADER);
        String apiKey = request.getHeader(SecurityUtils.APIKEY_HEADER);

        try {
            if (! SecurityUtils.verifyAccessToken(accessToken,apiKey, privateKey)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "REST signature failed validation.");
                return;
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "The REST Security Server experienced an internal error.");
            return;
        }

        filterChain.doFilter(request, response);
    }

}

