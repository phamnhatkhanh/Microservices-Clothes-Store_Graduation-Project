package com.clothesstore.orderservice.service;

import com.clothesstore.orderservice.dto.InventoryResponse;
import com.clothesstore.orderservice.dto.OrderLineItemsDto;
import com.clothesstore.orderservice.dto.OrderRequest;

import com.clothesstore.orderservice.model.Order;
import com.clothesstore.orderservice.model.OrderItem;

import com.clothesstore.orderservice.repository.OrderItemRepository;
import com.clothesstore.orderservice.repository.OrderRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

import java.util.List;


@Service
@RequiredArgsConstructor
//@Transactional
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final WebClient.Builder webClientBuilder;
    @Autowired
    private ModelMapper modelMapper;

    public String placeOrder(String orderRequest) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Order newOrder = objectMapper.readValue(orderRequest, Order.class);


            newOrder = orderRepository.save(newOrder);
            JsonNode orderJson = objectMapper.readTree(orderRequest);
            List<OrderItem> orderData = new ArrayList<>();
            for (JsonNode rawOrder : orderJson.get("items")) {
                OrderItem orderItem = modelMapper.map(rawOrder, OrderItem.class);
                orderItem.setOrderId(newOrder.getId());
                orderItem.setPrice(rawOrder.get("price").asDouble());
                orderItem.setQuantity(rawOrder.get("quantity").asInt());
                orderData.add(orderItem);

            }

            orderItemRepository.saveAll(orderData);

            return "Order placed successfully";
        } catch (Exception e) {
            log.error("Error processing the order request: " + e.getMessage(), e);
            return "Error processing the order request";
        }


//
//        Order order = new Order();
//        order.setOrderNumber(UUID.randomUUID().toString());
//        log.info("3.Order: list order item");
//        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
//                .stream()
//                .map(this::mapToDto)
//                .toList();
//
//        order.setOrderLineItemsList(orderLineItems);
//
//        List<String> skuCodes = order.getOrderLineItemsList().stream()
//                .map(OrderLineItems::getSkuCode)
//                .toList();
//
//        // Call Inventory Service, and place order if product is in
//        // stock
//        Observation inventoryServiceObservation = Observation.createNotStarted("inventory-service-lookup",
//                this.observationRegistry);
//        inventoryServiceObservation.lowCardinalityKeyValue("call", "inventory-service");
//        return inventoryServiceObservation.observe(() -> {
//            log.info("3.Inventory: call api check in stock");
//            InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
//                    .uri("http://inventory-service/api/inventory",
//                            uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
//                    .retrieve()
//                    .bodyToMono(InventoryResponse[].class)
//                    .block();
//
//            boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
//                    .allMatch(InventoryResponse::isInStock);
//            log.info("4.Inventory: get result");
//            log.info("Order checl {} ",inventoryResponseArray );
//            if (allProductsInStock) {
//                orderRepository.save(order);
//                // publish Order Placed Event
//                applicationEventPublisher.publishEvent(new OrderPlacedEvent(this, order.getOrderNumber()));
//                return "Order Placed Successfully";
//            } else {
//                throw new IllegalArgumentException("Product is not in stock, please try again later");
//            }
//        });

    }
}
