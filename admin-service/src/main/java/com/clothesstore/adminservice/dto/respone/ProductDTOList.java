package com.clothesstore.adminservice.dto.respone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTOList {
    @JsonProperty("products")
//    private List<Object> products;
    private List<ProductDTO> products;

}
