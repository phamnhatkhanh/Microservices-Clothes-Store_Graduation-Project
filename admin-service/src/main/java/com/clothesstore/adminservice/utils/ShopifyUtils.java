package com.clothesstore.adminservice.utils;

import jakarta.annotation.Resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Enumeration;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Service
public class ShopifyUtils {

    public boolean verifyPostHMAC(HttpServletRequest request, String requestBodyString){
        if(!isShopifyRequest(request)){
            return false;
        }

        try {
            // Get the HMAC header from the request
            String hmacHeader = request.getHeader("x-shopify-hmac-sha256");


            // Create an HMAC instance with the Shopify API secret
            Mac hmacSha256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec("f31ddeff3b25e395bb72fd96526e75b7".getBytes(), "HmacSHA256");
            hmacSha256.init(secretKeySpec);

            // Calculate the HMAC hash from the request body
            byte[] hashBytes = hmacSha256.doFinal(requestBodyString.getBytes(StandardCharsets.UTF_8));
            String calculatedHash = Base64.getEncoder().encodeToString(hashBytes);
            System.out.println("HMAC get header");
            System.out.println(hmacHeader);
            // Compare the calculated hash with the HMAC header
            if (calculatedHash.equals(hmacHeader)) {
                System.out.println("HMAC success");
                System.out.println(hmacHeader);
                return true;

            } else {
                System.out.println("HMAC failed");
                return false;
            }
        } catch (NoSuchAlgorithmException | InvalidKeyException e ) {
            System.out.println("Error in HMAC validation");
            e.printStackTrace();
            return false;
        }
    }
    public boolean isShopifyRequest(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement().toLowerCase();
            if (headerName.equals("x-shopify-hmac-sha256".toLowerCase())) {

                return true;
            }
        }
        return false;
    }
}

/*

public static function countDataCustomer($shop, $accessToken)
{
fe
    $client = new Client();
    $url = 'https://' . $shop . '/admin/api/2022-07/customers/count.json';
    $request = $client->request('get', $url, [
            'headers' => [
            'X-Shopify-Access-Token' => $accessToken,
            ]
        ]);
    $countCustomer = (array)json_decode($request->getBody());

    return $countCustomer;
}


    public static function setParam(array $headers, $params)
    {
        $links = explode(',', @$headers['Link'][0]);
        $nextPage = $prevPage = null;
        foreach ($links as $link) {
        if (strpos($link, 'rel="next"')) {
            $nextPage = $link;
        }
        if (strpos($link, 'rel="previous"')) {
            $prevPage = $link;
        }
    }

        $params = [];

        if ($nextPage) {
            preg_match('~<(.*?)>~', $nextPage, $next);
            $urlComponents = parse_url($next[1]);
            parse_str($urlComponents['query'], $parseStr);
            $params = $parseStr;
            $params['next_cursor'] = $parseStr['page_info'];
        }

        if ($prevPage) {
            preg_match('~<(.*?)>~', $prevPage, $next);
            $urlComponents = parse_url($next[1]);
            parse_str($urlComponents['query'], $parseStr);
            $params = !empty($params) ? $params : $parseStr;
            $params['prev_cursor'] = $parseStr['page_info'];
        }

        return $params;
    }
}
*
*/