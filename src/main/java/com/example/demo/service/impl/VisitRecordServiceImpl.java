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
package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository repository;

    public VisitRecordServiceImpl(VisitRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VisitRecord recordVisit(VisitRecord visit) {
        if (!List.of("STORE", "APP", "WEB").contains(visit.getChannel())) {
            throw new IllegalArgumentException("Invalid channel");
        }
        return repository.save(visit);
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return repository.findAll();
    }

    @Override
    public Optional<VisitRecord> getVisitById(Long id) {
        return repository.findById(id);
    }
}



