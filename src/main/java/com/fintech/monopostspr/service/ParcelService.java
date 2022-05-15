package com.fintech.monopostspr.service;

import com.fintech.monopostspr.converters.ParcelConverter;
import com.fintech.monopostspr.entity.Notification;
import com.fintech.monopostspr.repository.ParcelRepository;
import com.fintech.monopostspr.dto.request.ParcelRequest;
import com.fintech.monopostspr.entity.Parcel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final ParcelConverter parcelConverter;
    private final NotificationService notificationService;

    public Parcel create(ParcelRequest parcelRequest) {
        Parcel parcel = parcelRepository.save(parcelConverter.convertToEntity(parcelRequest));
        Notification notification = notificationService.creatNew();
        notification.setParcel(parcel);
        notificationService.save(notification);
        return parcel;
    }


    public List<Parcel> findAllNewParcels() {
        return parcelRepository.findAllNewParcels();
    }

    public void saveAllParcels(List<Parcel> parcels) {
        parcelRepository.saveAll(parcels);
    }
}
