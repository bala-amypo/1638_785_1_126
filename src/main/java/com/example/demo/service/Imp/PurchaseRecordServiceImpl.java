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
 public PurchaseRecord postdata(PurchaseRecord stu){
    return purchaseRecordRepository.save(stu);
 }
 @Override
 public List<PurchaseRecord> getAllData(){
      return purchaseRecordRepository.findAll();
 }
 @Override
 public  PurchaseRecord getData(int id){
    return purchaseRecordRepository.findById(id).orElse(null);
 }
 @Override
 public PurchaseRecordupdateData(int id,StudentEntity entity){
    if(purchaseRecordRepository.existsById(id)){
        entity.setId(id);
        return student.save(entity);
    }
     return null;
 }
}
