package com.clothesstore.adminservice.middleware;


import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Enumeration;
import java.util.stream.Collectors;


//@Component
//@RequiredArgsConstructor
//@Slf4j
public class ShopifyApiMiddleware {
//public class ShopifyApiMiddleware extends OncePerRequestFilter {
//
//    private static final String SHOPIFY_SECRET_KEY = "f31ddeff3b25e395bb72fd96526e75b7";
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        filterChain.doFilter(request, response);
//        if (isShopifyRequest(request)) {
//            String hmacHeader = request.getHeader("x-shopify-hmac-sha256");
//            ContentCachingRequestWrapper servletRequest = new ContentCachingRequestWrapper( request );
//
//            String requestBody = getRequestBody(servletRequest);
////            log.info("verifyWebhook " +  hmacHeader);
//            if (verifyWebhook(requestBody, hmacHeader)) {
//                log.info("verifyWebhook validation is true and request is from shopify" );
////                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                filterChain.doFilter(request, response);
//            } else {
//                log.info("verifyWebhook not request from shopify" );
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            }
//        } else {
////            Enumeration<String> headerNames = request.getHeaderNames();
////            while (headerNames.hasMoreElements()) {
////                String headerName = headerNames.nextElement();
////                log.info(headerName);
////            }
//            log.info("verifyWebhook not use hmac");
//            filterChain.doFilter(request, response);
//        }
//    }
//
//    private boolean isShopifyRequest(HttpServletRequest request) throws IOException  {
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement().toLowerCase();
//            if (headerName.equals("x-shopify-hmac-sha256".toLowerCase())) {
//
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    private String getRequestBody(HttpServletRequest request) throws IOException {
//        StringBuilder requestBody = new StringBuilder();
//
////        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
//
//        try (BufferedReader reader = request.getReader()) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                requestBody.append(line);
//            }
//        }
//
//
//
//        return requestBody.toString();
//    }
//
//    private boolean verifyWebhook(String data, String hmacHeader) {
//        try {
//            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
//            SecretKeySpec secretKey = new SecretKeySpec(SHOPIFY_SECRET_KEY.getBytes(), "HmacSHA256");
//            sha256_HMAC.init(secretKey);
//            byte[] hash = sha256_HMAC.doFinal(data.getBytes());
//            String calculatedHmac = Base64.getEncoder().encodeToString(hash);
//            log.info("verifyWebhook in function " +   hmacHeader.equals(calculatedHmac));
//            return hmacHeader.equals(calculatedHmac);
//        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

}