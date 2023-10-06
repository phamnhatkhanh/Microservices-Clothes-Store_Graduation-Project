package com.clothesstore.customerservice.dto;

import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
@Data
public class CustomerRequest {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("state")
    private String state;
    @JsonProperty("orders_count")
    private Integer ordersCount;
    @JsonProperty("total_spent")
    private Float totalSpent;
    @JsonProperty("addresses")
    private List<AddressRequest> addressRequest;

    // Constructors, getters, setters, and other methods as needed
}
