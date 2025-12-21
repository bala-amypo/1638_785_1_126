package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.VisitRecord;
import com.example.demo.service.VisitRecordService;
import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {
    @Autowired
    private VisitRecordService visitRecordService;
    @PostMapping
    public VisitRecord createVisit(@RequestBody VisitRecord visit) {
        return visitRecordService.recordVisit(visit);
    }
    @GetMapping("/{id}")
    public VisitRecord getVisitById(@PathVariable Long id) {
        return visitRecordService.getVisitById(id);
    }
    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable long customerId) {
        return visitRecordService.getVisitsByCustomer(customerId);
    }
    @GetMapping
    public List<VisitRecord> getAllVisits() {
        return visitRecordService.getAllVisits();
    }
}
