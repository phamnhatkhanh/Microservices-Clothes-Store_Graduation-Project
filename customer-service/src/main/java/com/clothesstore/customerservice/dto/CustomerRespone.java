package com.clothesstore.customerservice.dto;

import com.clothesstore.customerservice.model.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class CustomerRespone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String accessToken;
    private String phone;
    private String state;
    private String firstName;
    private String lastName;
    private Integer ordersCount;
    private Float totalSpent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String errorMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Address> addresses;
    public List<Address> getAddresses() {

        return addresses == null ? null : new ArrayList<>(addresses);
    }

    public void setAddresses(List<Address> addresses) {

        if (addresses == null) {
            this.addresses = null;
        } else {
            this.addresses = Collections.unmodifiableList(addresses);
        }
    }


}
