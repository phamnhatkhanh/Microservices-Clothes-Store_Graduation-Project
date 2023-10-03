package com.clothesstore.adminservice.dto.respone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRespone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String status;
    private String shopifyDomain;
    private String accessToken;
    private String address;
    private String province;
    private String city;
    private String zip;
    private String countryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
