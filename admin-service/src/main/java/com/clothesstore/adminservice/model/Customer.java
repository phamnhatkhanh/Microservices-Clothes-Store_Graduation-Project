package com.clothesstore.adminservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String status;
    @Column(name = "is_deleted")
    private Integer ordersCount;
    @Column(name = "is_activated")
    private Integer totalSpent;
    @Column(name = "address_id")
    private Long addressId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany(mappedBy = "customers")
    @EqualsAndHashCode.Exclude
    private List<Address> addresses;



}
