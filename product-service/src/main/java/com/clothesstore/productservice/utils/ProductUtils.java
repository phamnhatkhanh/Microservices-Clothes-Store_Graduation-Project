package com.clothesstore.productservice.utils;


import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ProductUtils {
//    @Autowired
//    private Environment env;
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public Customer mapModel(ProductRequest customerRequest, Customer dataCustomer){
//        Field[] allFieldDataCustomer = customerRequest.getClass().getDeclaredFields();
//        Field attributeCustomer;
//
//        for (Field dataItem : allFieldDataCustomer) {
//            dataItem.setAccessible(true);
//            try {
//                if (dataItem.get(customerRequest) != null) {
//                    if (dataItem.getType() == List.class) { // check field is List?
//
//                        Type genericType = dataItem.getGenericType();
//                        if (genericType instanceof ParameterizedType) { // get name model in list
//                            ParameterizedType parameterizedType = (ParameterizedType) genericType;
//                            Type[] typeArguments = parameterizedType.getActualTypeArguments();
//
//                            if (typeArguments.length > 0) { // ensure list not null
//                                Type typeArgument = typeArguments[0];
//                                if (typeArgument instanceof Class) {
//                                    Class<?> modelClassRequest = (Class<?>) typeArgument;
//                                    String nameClassRequest = modelClassRequest.getSimpleName();
//                                    String nameModelClass = nameClassRequest.substring(0, nameClassRequest.indexOf("Request"));
//
//                                    try {// convert list addresses request to list addresses model
//                                        Object modelInstance = Class.forName(env.getProperty("spring.path.model") +"."+nameModelClass).getDeclaredConstructor().newInstance();
//
//                                        List<?> itemDataList = (List<?>) dataItem.get(customerRequest);
//                                        List<?> resultList = itemDataList.stream()
//                                                .map(
//                                                        (itemData) -> modelMapper.map(itemData,modelInstance.getClass())
//                                                )
//                                                .collect(Collectors.toList());
//                                        log.info("List Addresses of the customer");
//
//                                        attributeCustomer = dataCustomer.getClass().getDeclaredField("addresses");
//                                        attributeCustomer.setAccessible(true);
//                                        attributeCustomer.set(dataCustomer, resultList);
//                                    } catch (Exception e) {
//
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }
//                        }
//
//
//                    } else {
//                        try {
//                            String fieldName = dataItem.getName();
//                            attributeCustomer = dataCustomer.getClass().getDeclaredField(fieldName);
//                            attributeCustomer.setAccessible(true);
//                            attributeCustomer.set(dataCustomer, dataItem.get(customerRequest));
//                        } catch (NoSuchFieldException e) {}
//                    }
//                }
//
//            } catch (IllegalAccessException a) {}
//        }
//
//        return dataCustomer;
//
//    }
}
