package com.clothesstore.adminservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private Long customer_id;
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
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "address_customer",
            joinColumns = @JoinColumn(name = "address_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id",referencedColumnName = "id"))
    private List<Customer> customers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "address_admin",
            joinColumns = @JoinColumn(name = "address_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "admin_id",referencedColumnName = "id"))
    private List<Admin> admins;

}
