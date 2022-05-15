package com.fintech.monopostspr.repository;

import com.fintech.monopostspr.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    Office findByAddress(String address);
}
