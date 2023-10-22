package com.clothesstore.adminservice.dto.respone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionDTOList {
    @JsonProperty("collects")
    private List<CollectionDTO> collects;


}
