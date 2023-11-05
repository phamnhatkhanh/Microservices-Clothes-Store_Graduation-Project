
package com.clothesstore.adminservice.controller;

import com.clothesstore.adminservice.service.ShopifyService;

import com.clothesstore.adminservice.utils.ShopifyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/admin/shopify")
public class ShopifyController {

    @Autowired
    private ShopifyService shopifyService;



    @GetMapping("/collections")
    public void syncCollectionsFromShopify(){
        shopifyService.syncCollectionsFromShopify();
    }

    @GetMapping("/products")
    public void syncProductsFromShopify(){
        shopifyService.syncProductsFromShopify();

    }
    @GetMapping("/customers")
    public void syncCustomersFromShopify(){
        shopifyService.syncCustomersFromShopify();
    }

    @GetMapping("/register-webhook")
    public String registerWebhook(){
        return  shopifyService.registerWebhookStore();

    }
    @DeleteMapping("/delete-webhook")
    public String deleteWebhook(){
        return  shopifyService.deleteWebhookStore();

    }
//    @PostMapping( "/webhooks")
//    public ResponseEntity<String> receivedWebhookFromShopify(@RequestBody String webhookData, HttpServletRequest request) {
//
//        if (shopifyUtils.verifyPostHMAC(request,webhookData)) {
//
//            webhookService.sendWebhookToService("toic");
//
//
//            return ResponseEntity.ok("validate sucess request from webhook");
//
//        }else {
//            log.info("verifyWebhook not request from shopify" );
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail request from webhook");
//
//        }
//
//    }



}
