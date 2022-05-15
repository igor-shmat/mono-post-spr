package com.fintech.monopostspr.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class UserRequest {

    @JsonProperty(value = "firstName")
    private String firstName;

    @JsonProperty(value = "secondName")
    private String secondName;

    @JsonProperty(value = "patronymicName")
    private String patronymicName;

    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;

    @JsonProperty(value = "email")
    private String email;
}
