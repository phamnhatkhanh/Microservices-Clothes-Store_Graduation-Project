package com.clothesstore.adminservice.service;

import com.clothesstore.adminservice.dto.CustomerRespone;
import com.clothesstore.adminservice.dto.CustomerResquest;
import com.clothesstore.adminservice.model.Customer;
import com.clothesstore.adminservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl {
    @Value("${shopify.domain.store}")
    private String shopifyDomain;
    @Value("${shopify.access.token}")
    private String shopifyAcesstoken;

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private Environment environment;
    private final WebClient.Builder webClientBuilder;

//
//    @Override
//    Customer getCustomerById(Long id){
//
//    }
//    List<Customer> getCustomers(){
//
//    }
//
//    @Override
//    Customer addCustomer(Customer customer){
//
//    }
//
//    @Override
//    Customer updateCustomer(Long id, Customer customer){
//
//    }
//
//    @Override
//    Customer deleteCustomerById(Long id){
//
//    }

    

    public ResponseEntity<Object> isInStock() {
        log.info("Start prepare {}");

        Object entities = webClientBuilder.build().get()
                .uri(shopifyDomain+"/admin/api/2023-04/customers.json",
                        uriBuilder -> uriBuilder.queryParam("ids", "5638817939665").build())
                .headers(
                        httpHeaders -> {
                            httpHeaders.set(environment.getProperty("shopify.header.token"), shopifyAcesstoken);

                        })

                .retrieve()
                .bodyToMono(Object.class)
                .block();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

}
