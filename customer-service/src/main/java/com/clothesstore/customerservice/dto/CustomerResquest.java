package com.clothesstore.customerservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
@Data
public class CustomerResquest {

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
    private List<AdressResquest> adressResquest;

    // Constructors, getters, setters, and other methods as needed
}
