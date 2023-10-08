package com.clothesstore.adminservice.dto.respone;

import com.clothesstore.adminservice.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
public class AddressDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String province;
    private String country;
    private String zip;
    private String phone;

    @JsonProperty("province_code")
    private String provinceCode;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("country_name")
    private String countryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
