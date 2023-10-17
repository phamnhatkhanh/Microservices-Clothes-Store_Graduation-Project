package com.clothesstore.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.awt.desktop.AppEvent;
import java.time.LocalDateTime;

@Data
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class CustomerDTO {
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
