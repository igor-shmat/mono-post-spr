package com.fintech.monopostspr.converters;

import com.fintech.monopostspr.dto.request.OfficeRequest;
import com.fintech.monopostspr.dto.response.OfficeResponse;
import com.fintech.monopostspr.entity.Office;
import org.springframework.stereotype.Component;

@Component
public class OfficeConverter {

    public Office convertToEntity(OfficeRequest officeRequest) {
        return Office.builder()
                .address(officeRequest.getAddress())
                .description(officeRequest.getDescription())
                .build();
    }

    public OfficeResponse convertToOfficeResponse(Office office) {
        return OfficeResponse.builder()
                .address(office.getAddress())
                .description(office.getDescription())
                .build();
    }
}
