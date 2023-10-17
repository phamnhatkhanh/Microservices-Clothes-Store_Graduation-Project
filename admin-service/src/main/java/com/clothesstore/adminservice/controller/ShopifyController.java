
package com.clothesstore.adminservice.controller;

import com.clothesstore.adminservice.dto.CustomerDTO;
import com.clothesstore.adminservice.service.ShopifyService;
import com.clothesstore.adminservice.service.WebhookService;
import com.clothesstore.adminservice.utils.ShopifyUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;


@Slf4j
@RestController
@RequestMapping("/api/admin/shopify")
public class ShopifyController {

    @Autowired
    private ShopifyService shopifyService;
    @Autowired
    private WebhookService webhookService;
    @Autowired
    private ShopifyUtils shopifyUtils;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @GetMapping("/test")
    public void test(){
        CustomerDTO customer = new CustomerDTO(
                "john_doe",
                "john.doe@example.com",
                "password123",
                "123-456-7890",
                "CA",
                "John",
                "Doe",
                3,
                100.50f,
                "No errors",
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        try {
            CompletableFuture<SendResult<String,Object>> future = kafkaTemplate.send("customer-topic", customer);
            future.whenComplete((result, ex) ->{
                if (ex == null) {
                    System.out.println("Sent message=[" + customer.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            customer.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception ex) {
            System.out.println("ERROR : "+ ex.getMessage());
        }






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
    @PostMapping( "/webhooks")
    public ResponseEntity<String> receivedWebhookFromShopify(@RequestBody String webhookData, HttpServletRequest request) {

        /*
         -1. switch webhook
        0. setting up kafka vs services.

        -2. recived data.
        3. send event to customer
        4. Customer: recieve event
        5. Save data
        6. add key cloack

        xem github -> paste code vaof.
        * */
        if (shopifyUtils.verifyPostHMAC(request,webhookData)) {

            webhookService.sendWebhookToService("toic");
            log.info("verifyWebhook validation is true and request is from shopify" );
            log.info(webhookData.toString());
            shopifyUtils.countDataCustomer();
//            System.out.println(String.valueOf());

            return ResponseEntity.ok("validate sucess request from webhook");

        }else {
            log.info("verifyWebhook not request from shopify" );
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("fail request from webhook");

        }




    }



}
