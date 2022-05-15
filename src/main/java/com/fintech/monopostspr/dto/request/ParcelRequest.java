package com.fintech.monopostspr.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fintech.monopostspr.enums.ParcelStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParcelRequest {

    @JsonProperty("userId")
    private Long user;

    @JsonProperty("senderOfficeId")
    private Long senderOffice;

    @JsonProperty("receiverOfficeId")
    private Long receiverOffice;

    @JsonProperty("receiverPhoneNumber")
    private String receiverPhoneNumber;

    @JsonProperty("receiverFirstName")
    private String receiverFirstName;

    @JsonProperty("receiverSecondName")
    private String receiverSecondName;

    @JsonProperty("receiverPatronymicName")
    private String receiverPatronymicName;

    private ParcelStatus parcelStatus;

    private LocalDateTime createDate;

    private LocalDateTime updateDateStatus;
}
