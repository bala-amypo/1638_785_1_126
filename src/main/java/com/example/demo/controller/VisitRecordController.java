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
@PostMapping("/api/visits")
public VisitRecord dopost(@RequestBody VisitRecord visit){
    return visitRecordService.recordVisit(visit);
}
@GetMapping("/api/visits")
public List<VisitRecord>getval(){
    return visitRecordService.getAllVisits();
}
@GetMapping("/api/visits/{id}")
public VisitRecord getdataid(@PathVariable Long id){
   return visitRecordService.getVisitsById(id);
}
@GetMapping("/getid/{id}")
public VisitRecord getdataid(@PathVariable long id){
   return visitRecordService.getData(id);
}
}
