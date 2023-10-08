package com.clothesstore.adminservice.dto.respone;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
public class CustomerCount  implements Serializable {
    @JsonProperty("count")
    private Integer count;
}
