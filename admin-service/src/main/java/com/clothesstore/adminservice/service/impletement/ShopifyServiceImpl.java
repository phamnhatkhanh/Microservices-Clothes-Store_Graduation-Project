package com.clothesstore.adminservice.service.impletement;

import com.clothesstore.adminservice.dto.WebhookRequest;
import com.clothesstore.adminservice.enums.ShopifyEnvironment;
import com.clothesstore.adminservice.service.ShopifyService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;

import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopifyServiceImpl implements ShopifyService {

    private final Environment environment;
    private final WebClient.Builder webClientBuilder;

    @Override
    public String registerWebhookStore() {
        String[] topicList = environment.getProperty(ShopifyEnvironment.TOPICS_PERMISSION.getValue()).split(",");
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
        String[] idWebhookList = environment.getProperty(ShopifyEnvironment.LIST_WEBHOOK.getValue()).split(",");
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

        webClientBuilder.baseUrl(environment.getProperty(ShopifyEnvironment.ROOT_LINK.getValue())).build();

        String webhookUrl = "/webhooks.json";
        HttpHeaders headers = new HttpHeaders();
        headers.add(
                environment.getProperty(ShopifyEnvironment.HEADER_TOKEN.getValue()).toString(),
                environment.getProperty(ShopifyEnvironment.ACCESS_TOKEN.getValue()).toString()
        );
        headers.setContentType(MediaType.APPLICATION_JSON);
        log.info(headers.toString());


        String addressWebhook = environment.getProperty(ShopifyEnvironment.ADDRESS_WEBHOOK.getValue());
        String requestBody = "{\"webhook\":{\"address\":\"" + addressWebhook + "\",\"topic\":" + topic + ",\"format\":\"json\"}}";

        Object object= new Object();
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

        webClientBuilder.baseUrl(environment.getProperty(ShopifyEnvironment.ROOT_LINK.getValue())).build();

        String webhookUrl = "/webhooks/"+idWebhook+".json";
        HttpHeaders headers = new HttpHeaders();
        headers.add(
                environment.getProperty(ShopifyEnvironment.HEADER_TOKEN.getValue()).toString(),
                environment.getProperty(ShopifyEnvironment.ACCESS_TOKEN.getValue()).toString()
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
