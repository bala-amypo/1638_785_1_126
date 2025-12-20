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
public PurchaseRecord dopost(@RequestBody PurchaseRecord purchase){
    return purchaseRecordService.recordPurchase(purchase);
}
@GetMapping("/api/purchases/{id}")
public List<PurchaseRecord>getdataid(@PathVariable Long id){
    return purchaseRecordService.getPurchaseById(id);
}
@GetMapping("/get/purchases/customer/{customerId}")
public PurchaseRecord getdataid(@PathVariable int customerId){
   return purchaseRecordService.getPurchasesByCustomer(customerId);
}
@GetMapping("/api/purchases")
public List<PurchaseRecord>getval(){
    return purchaseRecordService.getAllPurchases();
}
}
