package com.fintech.monopostspr.controller;

import com.fintech.monopostspr.converters.ParcelConverter;
import com.fintech.monopostspr.dto.request.ParcelRequest;
import com.fintech.monopostspr.dto.response.ParcelResponse;
import com.fintech.monopostspr.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parcel")
public class ParcelController {

    private final ParcelService parcelService;
    private final ParcelConverter parcelConverter;

    @PostMapping("/create")
    public ParcelResponse create(@RequestBody ParcelRequest parcelRequest) {
        return parcelConverter.convertToParcelResponse(parcelService.create(parcelRequest));
    }

    @GetMapping("/readAllParcels")
    public List<ParcelResponse> readAllParcels(){
        return parcelConverter.convertToListParcelResponse(parcelService.findAllParcels());
    }

    @GetMapping("/findParcelBySenderPhoneNumber/{phone}")
    public List<ParcelResponse> findParcelBySenderPhoneNumber(@PathVariable String phone){
        return parcelConverter.convertToListParcelResponse(parcelService.findByPhone(phone));
    }
}
