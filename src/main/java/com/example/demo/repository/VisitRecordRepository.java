package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.VisitRecord;
import java.util.List;
public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {
    List<VisitRecord> findByCustomerId(long customerId);
}
