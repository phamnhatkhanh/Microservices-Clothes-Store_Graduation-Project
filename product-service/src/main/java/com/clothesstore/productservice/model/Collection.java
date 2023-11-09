package com.clothesstore.productservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "collection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collection {

    @Id
    private Long id;

    private Long collectionId;

    private Long productId;

    private String createdAt;

    private String updatedAt;

    private int position;

    private String sortValue;


}
