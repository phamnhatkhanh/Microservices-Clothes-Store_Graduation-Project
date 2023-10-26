package com.clothesstore.productservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("collection_id")
    private long collectionId;

    @JsonProperty("product_id")
    private long productId;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("position")
    private int position;

    @JsonProperty("sort_value")
    private String sortValue;


}
