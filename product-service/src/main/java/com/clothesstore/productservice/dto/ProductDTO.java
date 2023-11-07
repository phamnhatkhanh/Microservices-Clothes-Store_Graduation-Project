package com.clothesstore.productservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;


@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body_html")
    private String bodyHtml;

    @JsonProperty("vendor")
    private String vendor;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("published_at")
    private String publishedAt;

    @JsonProperty("banner")
    private String banner;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("status")
    private String status;


}

