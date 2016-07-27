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

    // In order to get a valid accessTokek, apiKey, privateKey. Generate them using test case class SignatureVerificationIT
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String privateKey = "94ba6287-fe63-4b3b-98db-beefcfccc410";
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

