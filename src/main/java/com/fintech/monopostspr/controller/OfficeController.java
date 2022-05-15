package com.fintech.monopostspr.controller;

import com.fintech.monopostspr.converters.OfficeConverter;
import com.fintech.monopostspr.dto.request.OfficeRequest;
import com.fintech.monopostspr.dto.response.OfficeResponse;
import com.fintech.monopostspr.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/office")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    private final OfficeConverter officeConverter;

    @PostMapping("/create")
    public OfficeResponse create(@RequestBody OfficeRequest officeRequest) {
        return officeConverter.convertToOfficeResponse(officeService.create(officeRequest));
    }
}
