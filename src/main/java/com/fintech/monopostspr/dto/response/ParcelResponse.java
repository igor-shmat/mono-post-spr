package com.fintech.monopostspr.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fintech.monopostspr.entity.Office;
import com.fintech.monopostspr.entity.User;
import com.fintech.monopostspr.enums.ParcelStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ParcelResponse {

    private String userId;

    private String senderOfficeId;

    private String receiverOfficeId;

    private String receiverPhoneNumber;

    private String receiverFirstName;

    private String receiverSecondName;

    private String receiverPatronymicName;

    private ParcelStatus parcelStatus;

    private LocalDateTime createDate;

    private LocalDateTime updateDateStatus;
}
