package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.PurchaseRecordService;
import  com.example.demo.entity.PurchaseRecord;
import  com.example.demo.repository.PurchaseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService{
      @Autowired PurchaseRecordRepository purchaseRecordRepository;
     
      @Override
 public PurchaseRecord recordPurchase(PurchaseRecord purchase){
    return purchaseRecordRepository.save(purchase);
 }
 @Override
 public List<PurchaseRecord> getAllPurchases(){
      return purchaseRecordRepository.findAll();
 }
 @Override
 public List<PurchaseRecord> getPurchasesByCustomer(long customerId){
      return purchaseRecordRepository.findAll();
 }
 @Override
 public PurchaseRecord getPurchaseById(Long id){
    return purchaseRecordRepository.findById(id).orElse(null);
 }
}
