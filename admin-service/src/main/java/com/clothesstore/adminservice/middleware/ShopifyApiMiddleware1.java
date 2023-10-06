package com.clothesstore.adminservice.middleware;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Enumeration;



//@Component
//@RequiredArgsConstructor
//@Slf4j
//@Order(1)
public class ShopifyApiMiddleware1  {

    private static final String SHOPIFY_SECRET_KEY = "f31ddeff3b25e395bb72fd96526e75b7";

//    @Override
//    public void doFilter(
//            ServletRequest req ,
//            ServletResponse res,
//            FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse)res;
//        try {
//            // Get the HMAC header from the request
////            String hmacHeader = request.getHeader("X-Shopify-Hmac-SHA256");
//            String hmacHeader = request.getHeader("x-shopify-hmac-sha256");
//
//            // Create an HMAC instance with the Shopify API secret
//            Mac hmacSha256 = Mac.getInstance("HmacSHA256");
//            SecretKeySpec secretKeySpec = new SecretKeySpec(SHOPIFY_SECRET_KEY.getBytes(), "HmacSHA256");
//            hmacSha256.init(secretKeySpec);
//            String requestBody = getRequestBody(request);
//            // Calculate the HMAC hash from the request body
//            byte[] hashBytes = hmacSha256.doFinal(requestBody.getBytes("UTF-8"));
//            String calculatedHash = new String(Hex.encode(hashBytes));
//            System.out.println("HMAC get header");
//            System.out.println(hmacHeader);
//            // Compare the calculated hash with the HMAC header
//            if (calculatedHash.equals(hmacHeader)) {
//                System.out.println("HMAC success");
//                filterChain.doFilter(request, response);
//            } else {
//                System.out.println("HMAC failed");
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            }
//        } catch (NoSuchAlgorithmException | InvalidKeyException | IOException e) {
//            System.out.println("Error in HMAC validation");
//            e.printStackTrace();
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//
////        filterChain.doFilter(request, response);
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
//            SecretKeySpec secretKey = new SecretKeySpec(SHOPIFY_SECRET_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
//            sha256_HMAC.init(secretKey);
//            byte[] hash = sha256_HMAC.doFinal(data.getBytes());
//            String calculatedHmac = Base64.getEncoder().encodeToString(hash);
////            String hash = Hashing.hmacSha256("mykey".getBytes(StandardCharsets.UTF_8)).hashString("my_message", StandardCharsets.UTF_8).toString()
//
//            log.info("verifyWebhook in function " +   hmacHeader);
//            log.info("verifyWebhook in function " +   SHOPIFY_SECRET_KEY);
//            log.info("verifyWebhook in function " +   data);
//            log.info("verifyWebhook in function " +   hmacHeader.equals(calculatedHmac));
//            return hmacHeader.equals(calculatedHmac);
//        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

}