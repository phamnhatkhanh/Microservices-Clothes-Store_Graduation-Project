package com.clothesstore.productservice.listener;

import com.clothesstore.productservice.dto.ProductDTO;
import com.clothesstore.productservice.model.Product;
import com.clothesstore.productservice.repository.ProductRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductListener {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;
    @KafkaListener( topics = "sync-products-shopify",groupId = "ecommerce_group_id")
    public void receiveMessageFromAdmin(String productDtoJson) {
        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(productDtoJson);

//        JsonNode products = jsonNode.get("products");
        try{
            ProductDTO productDTO = objectMapper.readValue(productDtoJson, ProductDTO.class);
            Product dataProduct = modelMapper.map(productDTO,Product.class);

            productRepository.save(dataProduct);
            System.out.println("Received Product Id: " + productDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

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