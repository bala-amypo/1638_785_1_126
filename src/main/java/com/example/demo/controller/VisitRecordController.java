// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.entity.VisitRecord;
// import com.example.demo.service.VisitRecordService;
// import java.util.List;

// @RestController
// @RequestMapping("/api/visits")
// public class VisitRecordController {
//     @Autowired
//     private VisitRecordService visitRecordService;
//     @PostMapping
//     public VisitRecord createVisit(@RequestBody VisitRecord visit) {
//         return visitRecordService.recordVisit(visit);
//     }
//     @GetMapping("/{id}")
//     public VisitRecord getVisitById(@PathVariable Long id) {
//         return visitRecordService.getVisitById(id);
//     }
//     @GetMapping("/customer/{customerId}")
//     public List<VisitRecord> getVisitsByCustomer(@PathVariable long customerId) {
//         return visitRecordService.getVisitsByCustomer(customerId);
//     }
//     @GetMapping
//     public List<VisitRecord> getAllVisits() {
//         return visitRecordService.getAllVisits();
//     }
// }

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService service;

    public VisitRecordController(VisitRecordService service) {
        this.service = service;
    }

    @PostMapping
    public VisitRecord create(@RequestBody VisitRecord visit) {
        return service.recordVisit(visit);
    }

    @GetMapping("/{id}")
    public Optional<VisitRecord> getById(@PathVariable Long id) {
        return service.getVisitById(id);
    }

    @GetMapping
    public List<VisitRecord> getAll() {
        return service.getAllVisits();
    }

    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getByCustomer(
            @PathVariable Long customerId) {
        return service.getVisitsByCustomer(customerId);
    }
}

