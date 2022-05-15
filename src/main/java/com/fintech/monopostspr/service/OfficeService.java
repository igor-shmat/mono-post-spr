package com.fintech.monopostspr.service;

import com.fintech.monopostspr.converters.OfficeConverter;
import com.fintech.monopostspr.repository.OfficeRepository;
import com.fintech.monopostspr.dto.request.OfficeRequest;
import com.fintech.monopostspr.entity.Office;
import com.fintech.monopostspr.exceptions.EntityNotFoundException;
import com.fintech.monopostspr.exceptions.СreateInDbException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final OfficeConverter officeConverter;

    public Office create(OfficeRequest officeRequest) {
        Optional<Office> officeFromDB = Optional.ofNullable(officeRepository.findByAddress(officeRequest.getAddress()));
        if (officeFromDB.isEmpty()) {
            return officeRepository.save(officeConverter.convertToEntity(officeRequest));
        } else {
            throw new СreateInDbException("Office with address : " + officeRequest.getAddress() + " already exists");
        }
    }

    public Office findById(Long id){
        return officeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Office was not found"));
    }
}
