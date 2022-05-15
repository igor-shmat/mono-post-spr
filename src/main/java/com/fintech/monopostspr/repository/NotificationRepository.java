package com.fintech.monopostspr.repository;

import com.fintech.monopostspr.entity.Notification;
import com.fintech.monopostspr.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Notification findByParcel (Parcel parcel);
}
