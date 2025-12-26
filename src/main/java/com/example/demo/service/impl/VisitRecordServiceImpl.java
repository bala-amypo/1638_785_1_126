// package com.example.demo.service.Impl;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import com.example.demo.entity.VisitRecord;
// import com.example.demo.repository.VisitRecordRepository;
// import com.example.demo.service.VisitRecordService;
// import java.util.List;
// @Service
// public class VisitRecordServiceImpl implements VisitRecordService {

//     @Autowired
//     private VisitRecordRepository visitRecordRepository;

//     @Override
//     public VisitRecord recordVisit(VisitRecord visit) {
//         return visitRecordRepository.save(visit);
//     }

//     @Override
//     public VisitRecord getVisitById(Long id) {
//         return visitRecordRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<VisitRecord> getVisitsByCustomer(long customerId) {
//         return visitRecordRepository.findByCustomerId(customerId);
//     }

//     @Override
//     public List<VisitRecord> getAllVisits() {
//         return visitRecordRepository.findAll();
//     }
// }
