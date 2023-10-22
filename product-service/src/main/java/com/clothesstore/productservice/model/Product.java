package com.clothesstore.productservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String bodyHtml;

    private String vendor;

    private String productType;

    private String createdAt;

    private String handle;

    private String updatedAt;

    private String publishedAt;

    private String templateSuffix;

    private String publishedScope;

    private String tags;

    private String status;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "product_category",
//            joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "catefory_id",referencedColumnName = "id"))
//    private List<Collection> collections;


}
