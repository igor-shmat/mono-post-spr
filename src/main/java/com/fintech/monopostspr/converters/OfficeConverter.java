package com.fintech.monopostspr.converters;

import com.fintech.monopostspr.dto.request.OfficeRequest;
import com.fintech.monopostspr.dto.response.OfficeResponse;
import com.fintech.monopostspr.entity.Office;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
                .officeId(office.getPkey())
                .address(office.getAddress())
                .description(office.getDescription())
                .build();
    }

    public List<OfficeResponse> convertToListOfficeResponse(List<Office> offices){
        return offices.stream().map(this::convertToOfficeResponse)
                .sorted(Comparator.comparingLong(OfficeResponse::getOfficeId))
                .collect(Collectors.toList());
    }
}
