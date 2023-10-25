package com.clothesstore.productservice.dto;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
public class ProductRespone {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String state;
    private String firstName;
    private String lastName;
    private Integer ordersCount;
    private Float totalSpent;
    private String errorMessage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private List<Address> addresses;


}
