package com.fintech.monopostspr.converters;

import com.fintech.monopostspr.dto.request.ParcelRequest;
import com.fintech.monopostspr.dto.response.ParcelResponse;
import com.fintech.monopostspr.entity.Parcel;
import com.fintech.monopostspr.enums.ParcelStatus;
import com.fintech.monopostspr.service.OfficeService;
import com.fintech.monopostspr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class ParcelConverter {

    private final UserService userService;
    private final OfficeService officeService;

    public Parcel convertToEntity(ParcelRequest parcelRequest) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return Parcel.builder()
                .user(userService.findById(parcelRequest.getUser()))
                .senderOffice(officeService.findById(parcelRequest.getSenderOffice()))
                .receiverOffice(officeService.findById(parcelRequest.getReceiverOffice()))
                .receiverPhoneNumber(parcelRequest.getReceiverPhoneNumber())
                .receiverFirstName(parcelRequest.getReceiverFirstName())
                .receiverSecondName(parcelRequest.getReceiverSecondName())
                .receiverPatronymicName(parcelRequest.getReceiverPatronymicName())
                .parcelStatus(ParcelStatus.NEW)
                .createDate(localDateTime)
                .updateDateStatus(localDateTime)
                .build();

    }

    public ParcelResponse convertToParcelResponse(Parcel parcel) {
        return ParcelResponse.builder()
                .parcelId(parcel.getPkey())
                .userId(parcel.getUser().getPkey().toString())
                .senderOfficeId(parcel.getSenderOffice().getPkey().toString())
                .receiverOfficeId(parcel.getReceiverOffice().getPkey().toString())
                .receiverPhoneNumber(parcel.getReceiverPhoneNumber())
                .receiverFirstName(parcel.getReceiverFirstName())
                .receiverSecondName(parcel.getReceiverSecondName())
                .receiverPatronymicName(parcel.getReceiverPatronymicName())
                .parcelStatus(parcel.getParcelStatus())
                .createDate(parcel.getCreateDate())
                .updateDateStatus(parcel.getUpdateDateStatus())
                .build();
    }

    public List<ParcelResponse> convertToListParcelResponse(List<Parcel> parcels){
        return parcels.stream().map(this::convertToParcelResponse)
                .sorted(Comparator.comparingLong(ParcelResponse::getParcelId).reversed())
                .collect(Collectors.toList());
    }
}
