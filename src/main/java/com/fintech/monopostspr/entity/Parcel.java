package com.fintech.monopostspr.entity;

import com.fintech.monopostspr.enums.ParcelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parcels", schema = "mono_post")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Office senderOffice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Office receiverOffice;

    @Column
    private String receiverPhoneNumber;

    @Column
    private String receiverFirstName;

    @Column
    private String receiverSecondName;

    @Column
    private String receiverPatronymicName;

    @Column
    @Enumerated(value = EnumType.STRING)
    private ParcelStatus parcelStatus;

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime updateDateStatus;
}
