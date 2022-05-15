package com.fintech.monopostspr.service;

import com.fintech.monopostspr.entity.Notification;
import com.fintech.monopostspr.entity.Parcel;
import com.fintech.monopostspr.enums.NotificationStatus;
import com.fintech.monopostspr.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Notification creatNew(){
        return Notification.builder()
                .notificationStatus(NotificationStatus.NEW)
                .build();
    }

    public void save(Notification notification){
        notificationRepository.save(notification);
    }

    public Notification findNote(Parcel parcel){
        return notificationRepository.findByParcel(parcel);
    }
}
