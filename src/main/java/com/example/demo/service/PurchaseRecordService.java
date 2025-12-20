package com.example.demo.service;
import com.example.demo.entity.PurchaseRecord;
import java.util.List;
public interface PurchaseRecordService{
    PurchaseRecord recordPurchase(StudentEntity stu);
    List<StudentEntity> getAllData();
    StudentEntity getData(int id);
}
