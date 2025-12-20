package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Purchase;
import com.example.demo.service.StudentService;
import java.util.List;

@RestController
public class StudentController{
    @Autowired StudentService ser;
@PostMapping("/post")
public StudentEntity dopost(@RequestBody StudentEntity stu){
    return ser.postdata(stu);
}
@GetMapping("/get")
public List<StudentEntity>getval(){
    return ser.getAllData();
}
@DeleteMapping("/delete/{id}")
public String deleteval(@PathVariable int id){
    return ser.deleteData(id); 
}
@GetMapping("/getid/{id}")
public StudentEntity getdataid(@PathVariable int id){
   return ser.getData(id);
}
@PutMapping ("/put/{id}")
public StudentEntity putval(@PathVariable int id, @RequestBody StudentEntity entity){
 return ser.updateData(id,entity);
}
}
