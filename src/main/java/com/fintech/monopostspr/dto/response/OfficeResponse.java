package com.fintech.monopostspr.dto.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class OfficeResponse {

    private Long officeId;

    private String address;

    private String description;
}
