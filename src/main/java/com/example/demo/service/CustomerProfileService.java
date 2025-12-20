package com.example.demo.service;
import com.example.demo.entity.CustomerProfile;
import java.util.List;
public interface StudentService{
     postdata(StudentEntity stu);
    List<StudentEntity> getAllData();
    String deleteData(int id);
    StudentEntity getData(int id);
    StudentEntity updateData(int id,StudentEntity entity);
}
