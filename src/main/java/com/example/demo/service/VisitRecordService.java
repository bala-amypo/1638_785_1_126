package com.example.demo.service;
import com.example.demo.entity.VisitRecord;
import java.util.List;
public interface VisitRecordService{
    VisitRecord recordVisit(VisitRecord visit);
    List<VisitRecord> getAllData();
    StudentEntity getData(int id);
    StudentEntity updateData(int id,StudentEntity entity);
}

