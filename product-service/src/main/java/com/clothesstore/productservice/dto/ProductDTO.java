package com.clothesstore.productservice.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductDTO {
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
