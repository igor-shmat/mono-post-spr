package com.fintech.monopostspr.service;

import com.fintech.monopostspr.converters.ParcelConverter;
import com.fintech.monopostspr.dto.response.ParcelResponse;
import com.fintech.monopostspr.entity.Notification;
import com.fintech.monopostspr.entity.User;
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
    private final UserService userService;

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

    public List<Parcel> findAllParcels(){
        return parcelRepository.findAll();
    }

    public List<Parcel> findByPhone(String phone){
        User user = userService.findByPhoneNumber(phone);
        return parcelRepository.findAllByUser(user);
    }
}
