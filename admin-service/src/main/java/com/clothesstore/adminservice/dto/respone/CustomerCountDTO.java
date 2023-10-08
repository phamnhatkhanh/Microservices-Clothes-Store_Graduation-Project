package com.clothesstore.adminservice.dto.respone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
public class CustomerCountDTO implements Serializable {
    @JsonProperty("count")
    private Integer count;
}
