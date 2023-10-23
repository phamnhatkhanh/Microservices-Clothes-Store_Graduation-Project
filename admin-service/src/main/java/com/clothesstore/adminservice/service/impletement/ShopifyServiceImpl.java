package com.clothesstore.adminservice.service.impletement;


import com.clothesstore.adminservice.enums.ShopifyEnvironment;
import com.clothesstore.adminservice.service.ShopifyService;
import com.clothesstore.adminservice.utils.ShopifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;

import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopifyServiceImpl implements ShopifyService {


    @Autowired
    private Environment env;
    
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ShopifyUtils shopifyUtils;

    @Override
    public void syncCustomersFromShopify() {
        int limit = 100;

        // Count number of Customers
        int countCustomer = shopifyUtils.countDataCustomer();
      
        HttpHeaders headers = new HttpHeaders();
        headers.add(
                env.getProperty(ShopifyEnvironment.HEADER_TOKEN.getValue()).toString(),
                env.getProperty(ShopifyEnvironment.ACCESS_TOKEN.getValue()).toString()
        );

        shopifyUtils.fetchDataShopify(headers,"/customers.json",countCustomer,limit);
    }
    @Override
    public void syncProductsFromShopify() {
        int limit = 30;

        // Count number of Customers
        int countProducts = shopifyUtils.countDataProduct();
        int ceilRequest = (int) Math.ceil(countProducts / (double) limit);
        int numberRequest = countProducts > limit ? ceilRequest : 1;
        HttpHeaders headers = new HttpHeaders();
        headers.add(
                env.getProperty(ShopifyEnvironment.HEADER_TOKEN.getValue()).toString(),
                env.getProperty(ShopifyEnvironment.ACCESS_TOKEN.getValue()).toString()
        );
        shopifyUtils.fetchDataShopify(headers,"/products.json",countProducts,limit);

    }

    @Override
    public String registerWebhookStore() {
        String[] topicList = env.getProperty(ShopifyEnvironment.TOPICS_PERMISSION.getValue()).split(",");
        Integer i = 0;
        System.out.println(topicList.length);

        try{
            for (String topic:
                    topicList) {
                i++;
                System.out.println("stt " + i);
                log.info("Register topic: " + topic );
                this.createWebhook(topic);

            }
            return "Successly register webhook";
        }catch (Exception e){
            e.printStackTrace();
            return "Error in processing to register webhook";
        }

    }

    @Override
    public String deleteWebhookStore() {
        String[] idWebhookList = env.getProperty(ShopifyEnvironment.LIST_WEBHOOK.getValue()).split(",");
        Integer i = 0;
        System.out.println(idWebhookList.length);

        try{
            for (String idWebhook:
                    idWebhookList) {
                i++;
                System.out.println("stt " + i);
                log.info("Register topic: " + idWebhook );
                this.deleteWebhook(idWebhook);

            }
            return "Successly delete webhook";
        }catch (Exception e){
            e.printStackTrace();
            return "Error in processing to delete webhook";
        }
    }

    public void createWebhook(String topic) {

        webClientBuilder.baseUrl(env.getProperty(ShopifyEnvironment.API_LINK.getValue())).build();

        String webhookUrl = "/webhooks.json";
        HttpHeaders headers = new HttpHeaders();
        headers.add(
                env.getProperty(ShopifyEnvironment.HEADER_TOKEN.getValue()).toString(),
                env.getProperty(ShopifyEnvironment.ACCESS_TOKEN.getValue()).toString()
        );
        headers.setContentType(MediaType.APPLICATION_JSON);
        log.info(headers.toString());


        String addressWebhook = env.getProperty(ShopifyEnvironment.ADDRESS_WEBHOOK.getValue());
        String requestBody = "{\"webhook\":{\"address\":\"" + addressWebhook + "\",\"topic\":" + topic + ",\"format\":\"json\"}}";

        try{

            Mono<String> responseMono = webClientBuilder.build().post()
                    .uri(webhookUrl)
                    .headers(httpHeaders -> httpHeaders.addAll(headers))
                    .body(BodyInserters.fromValue(requestBody))
                            .retrieve().bodyToMono(String.class);


            responseMono.subscribe(
                    response -> {
                        // Handle the response as a string
                        System.out.println("Response: " + response);
                    },
                    error -> {
                        // Handle any errors
                        System.err.println("Error occurred: " + error.getMessage());
                    }
            );
//            return "Successly register webhook";
        }catch (Exception e){
            e.printStackTrace();
//            return "Error in processing to register webhook";
        }
    }

    public void deleteWebhook(String idWebhook) {

        webClientBuilder.baseUrl(env.getProperty(ShopifyEnvironment.API_LINK.getValue())).build();

        String webhookUrl = "/webhooks/"+idWebhook+".json";
        HttpHeaders headers = new HttpHeaders();
        headers.add(
                env.getProperty(ShopifyEnvironment.HEADER_TOKEN.getValue()).toString(),
                env.getProperty(ShopifyEnvironment.ACCESS_TOKEN.getValue()).toString()
        );


        try{

            Mono<String> responseMono = webClientBuilder.build().delete()
                    .uri(webhookUrl)
                    .headers(httpHeaders -> httpHeaders.addAll(headers))
                    .retrieve().bodyToMono(String.class);


            responseMono.subscribe(
                    response -> {
                        // Handle the response as a string
                        System.out.println("Response: " + response);
                    },
                    error -> {
                        // Handle any errors
                        System.err.println("Error occurred: " + error.getMessage());
                    }
            );

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
