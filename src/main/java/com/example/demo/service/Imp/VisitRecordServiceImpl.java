package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.VisitRecordService;
import  com.example.demo.entity.VisitRecordEntity;
import  com.example.demo.repository.VisitRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class VisitRecordServiceImpl implements VisitRecordService{
      @Autowired StudentRepository student;
      //save()
      //findall()
      //findById()
      //deleteById()
      //existsById()
      @Override
 public StudentEntity postdata(StudentEntity stu){
    return student.save(stu);
 }
 @Override
 public List<StudentEntity> getAllData(){
      return student.findAll();
 }
 @Override
 public  String deleteData(int id){
     student.deleteById(id);
     return "Deleted Successfully";
 }
 @Override
 public  StudentEntity getData(int id){
    return student.findById(id).orElse(null);
 }
 @Override
 public  StudentEntity updateData(int id,StudentEntity entity){
    if(student.existsById(id)){
        entity.setId(id);
        return student.save(entity);
    }
     return null;
 }
}
