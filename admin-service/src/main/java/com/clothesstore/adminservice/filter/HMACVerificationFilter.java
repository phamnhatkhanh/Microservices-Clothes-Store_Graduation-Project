package com.clothesstore.adminservice.filter;

import java.io.IOException;
import java.util.Enumeration;

import com.clothesstore.adminservice.utils.ShopifyUtils;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * This Servlet Filter is responsible for verifying the authenticity of the request from Shopify using the HMAC signature.
 *
 * @author justblackmagic
 */
@Slf4j
@Data
public class HMACVerificationFilter{

    // Normally we'd Autowire this, but since we are using the FilterRegistrationConfig class, we have to manually inject it from there

    private ShopifyUtils shopifyUtils;

    /**
     * @param request
     * @param response
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        log.debug("HMACVerificationFilter.doFilter() - called...");
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        if (shopifyUtils.isShopifyRequest(httpRequest)) {
//            request.setAttribute("shopifyHMACValid", true);
//            filterChain.doFilter(request, response);
//        } else {
//            request.setAttribute("shopifyHMACValid", false);
//            filterChain.doFilter(request, response);
//        }
//
//    }


}