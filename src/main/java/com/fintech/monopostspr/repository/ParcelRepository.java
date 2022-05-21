package com.fintech.monopostspr.repository;

import com.fintech.monopostspr.entity.Parcel;
import com.fintech.monopostspr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {

    @Query(value = "select * from mono_post.parcels p \n" +
            "where parcel_status = 'NEW'", nativeQuery = true)
    List<Parcel> findAllNewParcels();

    List<Parcel> findAllByUser(User user);
}
