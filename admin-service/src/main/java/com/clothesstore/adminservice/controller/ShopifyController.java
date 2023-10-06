
package com.clothesstore.adminservice.controller;

import com.clothesstore.adminservice.service.ShopifyService;
import com.clothesstore.adminservice.utils.ShopifyUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static javax.xml.crypto.dsig.SignatureMethod.HMAC_SHA256;


@Slf4j
@RestController
@RequestMapping("/api/admin/shopify")
public class ShopifyController {

    @Autowired
    private ShopifyService shopifyService;
    @Autowired
    private ShopifyUtils shopifyUtils;

    @GetMapping("/register-webhook")
    public String registerWebhook(){
        return  shopifyService.registerWebhookStore();

    }
    @DeleteMapping("/delete-webhook")
    public String deleteWebhook(){
        return  shopifyService.deleteWebhookStore();

    }
    @PostMapping( "/webhooks")
    public ResponseEntity<String> receivedCustomerCreatedWebhook(@RequestBody String webhookData, HttpServletRequest request) {

        if (shopifyUtils.verifyPostHMAC(request,webhookData)) {
            log.info("verifyWebhook validation is true and request is from shopify" );
            log.info(webhookData.toString());
                return ResponseEntity.ok("validate sucess request from webhook");

        }else {
            log.info("verifyWebhook not request from shopify" );
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail request from webhook");

        }




    }



}
