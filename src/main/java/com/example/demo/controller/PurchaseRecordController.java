package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import java.util.List;

@RestController
public class PurchaseRecordController{
    @Autowired PurchaseRecordService purchaseRecordService;
@PostMapping("/api/purchases")
public PurchaseRecord dopost(@RequestBody PurchaseRecord stu){
    return purchaseRecordService.postdata(stu);
}
@GetMapping("/get")
public List<PurchaseRecord>getval(){
    return purchaseRecordService.getAllData();
}
@GetMapping("/getid/{id}")
public PurchaseRecord getdataid(@PathVariable int id){
   return purchaseRecordService.getData(id);
}
@PutMapping ("/put/{id}")
public PurchaseRecord putval(@PathVariable int id, @RequestBody PurchaseRecord entity){
 return purchaseRecordService.updateData(id,entity);
}
}
