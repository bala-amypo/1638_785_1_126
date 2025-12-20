package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;

import java.util.List;

@RestController
public class PurchaseRecordController {

    @Autowired
    private PurchaseRecordService purchaseRecordService;

    @PostMapping("/api/purchases")
    public PurchaseRecord createPurchase(@RequestBody PurchaseRecord purchase) {
        return purchaseRecordService.recordPurchase(purchase);
    }

    @GetMapping("/api/purchases/{id}")
    public PurchaseRecord getPurchaseById(@PathVariable Long id) {
        return purchaseRecordService.getPurchaseById(id);
    }

    @GetMapping("/api/purchases/customer/{customerId}")
    public List<PurchaseRecord> getPurchasesByCustomer(@PathVariable int customerId) {
        return purchaseRecordService.getPurchasesByCustomer(customerId);
    }

    @GetMapping("/api/purchases")
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseRecordService.getAllPurchases();
    }
}
