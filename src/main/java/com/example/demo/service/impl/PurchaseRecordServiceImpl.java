// package com.example.demo.service.Impl;
// import org.springframework.stereotype.Service;
// import com.example.demo.service.PurchaseRecordService;
// import  com.example.demo.entity.PurchaseRecord;
// import  com.example.demo.repository.PurchaseRecordRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import java.util.List;

// @Service
// public class PurchaseRecordServiceImpl implements PurchaseRecordService{
//       @Autowired PurchaseRecordRepository purchaseRecordRepository;
     
//       @Override
//  public PurchaseRecord recordPurchase(PurchaseRecord purchase){
//     return purchaseRecordRepository.save(purchase);
//  }
//  @Override
//  public List<PurchaseRecord> getAllPurchases(){
//       return purchaseRecordRepository.findAll();
//  }
//  @Override
//  public List<PurchaseRecord> getPurchasesByCustomer(long customerId){
//       return purchaseRecordRepository.findAll();
//  }
//  @Override
//  public PurchaseRecord getPurchaseById(Long id){
//     return purchaseRecordRepository.findById(id).orElse(null);
//  }
// }
package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository repository;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseRecord recordPurchase(PurchaseRecord purchase) {
        if (purchase.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        return repository.save(purchase);
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<PurchaseRecord> getAllPurchases() {
        return repository.findAll();
    }

    @Override
    public Optional<PurchaseRecord> getPurchaseById(Long id) {
        return repository.findById(id);
    }
}
