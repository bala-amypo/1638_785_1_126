package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.VisitRecordService;
import  com.example.demo.entity.VisitRecordEntity;
import  com.example.demo.repository.VisitRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class VisitRecordServiceImpl implements VisitRecordService{
      @Autowired VisitRecordRepository visitRecordRepository;
      @Override
 public VisitRecord recordVisit(VisitRecord visit){
    return visitRecordRepository.save(visit);
 }
 @Override
 public List<VisitRecord> getAllVisits(){
      return visitRecordRepository.findAll();
 }
 @Override
 public  VisitRecord getVisitById(Long id){
    return visitRecordRepository.findById(id).orElse(null);
 }
  @Override
 public  VisitRecord getVisitByCustomer(long customerId){
    return visitRecordRepository.findBycustomerId(customerId).orElse(null);
 }

}
