package com.fintech.monopostspr.entity;
import com.fintech.monopostspr.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifications", schema = "mono_post")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkey;
    @OneToOne
    @JoinColumn
    private Parcel parcel;
    @Column
    @Enumerated(value = EnumType.STRING)
    private NotificationStatus notificationStatus;
    @Column
    private String texts;
}
