package com.example.demo.service;
import com.example.demo.entity.VisitRecord;
import java.util.List;
public interface VisitRecordService{
    VisitRecord recordVisit(VisitRecord visit);
    List<VisitRecord> getAllVisits();
    List<VisitRecord> getVisitsByCustomer(long customerId);
    VisitRecord getVisitById(Long id);
}

