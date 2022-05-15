package com.fintech.monopostspr.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String firstName;

    private String secondName;

    private String patronymicName;

    private String phoneNumber;

    private String email;

}
