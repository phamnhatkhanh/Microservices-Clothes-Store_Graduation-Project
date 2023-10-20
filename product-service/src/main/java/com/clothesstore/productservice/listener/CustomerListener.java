package com.clothesstore.productservice.listener;

import org.springframework.kafka.annotation.KafkaListener;

public class CustomerListener {

    @KafkaListener(id = "customer-listener", topics = "customer-topic")
    public void receiveMessageFromAdmin(String data) {

        System.out.println("Received message from Admin: " + data);
    }
}

//@Component
//@KafkaListener(id = "so65866763", topics = "tp-sale.request")
//public class ConsumerListener {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerListener.class);
//
//    @KafkaHandler
//    @SendTo("tp-sale.reply")
//    public AuthResponseFactory fooListener(AuthRequestFactory authRequestFactory) {
//        System.out.println("In AuthRequestFactoryListener: " + authRequestFactory);
//
//        AuthResponseFactory resObj = new AuthResponseFactory();
//        resObj.setUnique_id("123123");
//
//        return resObj;
//    }
//
//    @KafkaHandler
//    @SendTo("tp-sale.reply")
//    public SaleResponseFactory barListener(SaleRequestFactory saleRequestFactory) {
//        System.out.println("In SaleRequestFactoryListener: " + saleRequestFactory);
//
//        SaleResponseFactory resObj = new SaleResponseFactory();
//        resObj.setUnique_id("123123");
//
//        return resObj;
//    }
//}