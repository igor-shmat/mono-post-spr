package com.fintech.monopostspr.service;

import com.fintech.monopostspr.entity.Notification;
import com.fintech.monopostspr.entity.Parcel;
import com.fintech.monopostspr.enums.NotificationStatus;
import com.fintech.monopostspr.enums.ParcelStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ParcelDeliveringService {

    private final ParcelService parcelService;
    private final NotificationService notificationService;

    public void saveStatus() {
        List<Parcel> parcels = checkNewParcels();
        for (Parcel parcel : parcels) {
            checkStatus(parcel);
        }
        parcelService.saveAllParcels(parcels);
    }

    public void checkStatus(Parcel parcel) {
        Notification notification = notificationService.findNote(parcel);
        ParcelStatus status = ParcelStatus.generateRandomStatus();
        parcel.setParcelStatus(status);
        if (status.equals(ParcelStatus.DELIVERED)){
            parcel.setUpdateDateStatus(LocalDateTime.now());
            notification.setNotificationStatus(NotificationStatus.SENT);
            notification.setTexts("Your parcel was successfully delivered");
        }
        LocalDateTime start = parcel.getUpdateDateStatus();
        LocalDateTime end = parcel.getCreateDate();
        Duration duration = Duration.between(end, start);
        Long time = TimeUnit.MILLISECONDS.convert(duration);
        if (time > 5000) {
            parcel.setParcelStatus(ParcelStatus.OVERDUE);
            notification.setNotificationStatus(NotificationStatus.SENT);
            notification.setTexts("Your parcel was returned back");

        }
        notificationService.save(notification);
    }

    public List<Parcel> checkNewParcels() {
        return parcelService.findAllNewParcels();
    }
}
