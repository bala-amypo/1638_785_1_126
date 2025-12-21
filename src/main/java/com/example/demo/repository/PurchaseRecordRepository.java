package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.PurchaseRecord;
import java.util.List;

@Repository
public interface PurchaseRecordRepository
        extends JpaRepository<PurchaseRecord, Long> {

    List<PurchaseRecord> findByCustomerId(Long customerId);
}
