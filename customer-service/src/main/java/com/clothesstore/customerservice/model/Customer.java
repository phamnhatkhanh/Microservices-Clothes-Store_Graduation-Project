package com.clothesstore.customerservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
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
    @Column(name = "access_token")
    private String accessToken;
    private String phone;
    private String state;
    @Column(name = "orders_count")
    private Integer ordersCount;
    @Column(name = "total_spent")
    private Float totalSpent;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
    private List<Address> addresses;



}
