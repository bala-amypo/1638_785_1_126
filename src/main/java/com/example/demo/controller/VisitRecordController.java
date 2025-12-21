package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.VisitRecord;
import com.example.demo.service.VisitRecordService;
import java.util.List;

@RestController
public class VisitRecordController{
    @Autowired VisitRecordService visitRecordService;
@PostMapping("/post")
public VisitRecord dopost(@RequestBody VisitRecord visit){
    return visitRecordService.postdata(visit);
}
@GetMapping("/get")
public List<VisitRecord>getval(){
    return visitRecordService.getAllData();
}
@GetMapping("/getid/{id}")
public VisitRecord getdataid(@PathVariable int id){
   return ser.getData(id);
}
}
