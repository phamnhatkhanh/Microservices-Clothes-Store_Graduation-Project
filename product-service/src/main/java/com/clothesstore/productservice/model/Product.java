package com.clothesstore.productservice.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    private String updatedAt;

    private String publishedAt;

    private String banner;

    private Double price;

    private String tags;

    private String status;


}
