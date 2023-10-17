package com.clothesstore.customerservice.dto;

import com.clothesstore.customerservice.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
public class CustomerRespone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<Address> addresses;


}
