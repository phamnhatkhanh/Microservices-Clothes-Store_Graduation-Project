package com.clothesstore.adminservice.dto.respone;

import com.clothesstore.adminservice.model.Address;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
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
    private List<Address> addresses;


}
