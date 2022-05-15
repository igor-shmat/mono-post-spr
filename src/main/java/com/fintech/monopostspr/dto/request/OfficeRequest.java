package com.fintech.monopostspr.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class OfficeRequest {

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;
}
