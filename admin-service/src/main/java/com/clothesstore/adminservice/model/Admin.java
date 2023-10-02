package com.clothesstore.adminservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;



import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import jakarta.persistence.*;
        import java.util.List;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String status;
    @Column(name = "shpoify_domain")
    private String shopifyDomain;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "address_id")
    private Long addressId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany(mappedBy = "admins")
    private List<Address> addresses;

//    @Lob
//    @Column(columnDefinition = "MEDIUMBLOB")
//    private String image;
}
