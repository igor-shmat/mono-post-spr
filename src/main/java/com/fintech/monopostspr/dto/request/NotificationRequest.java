package com.fintech.monopostspr.dto.request;

import com.fintech.monopostspr.entity.Parcel;
import com.fintech.monopostspr.enums.NotificationStatus;
import lombok.Data;


@Data
public class NotificationRequest {

    private Parcel parcel;

    private NotificationStatus notificationStatus;

    private String texts;
}
