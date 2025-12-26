// package com.example.demo.service;
// import com.example.demo.entity.PurchaseRecord;
// import java.util.List;
// public interface PurchaseRecordService{
//     PurchaseRecord recordPurchase(PurchaseRecord purchase);
//     List<PurchaseRecord> getAllPurchases();
//     List<PurchaseRecord> getPurchasesByCustomer(long customerId);
//     PurchaseRecord getPurchaseById(Long id);
// }
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.PurchaseRecord;

public interface PurchaseRecordService {

    PurchaseRecord recordPurchase(PurchaseRecord purchase);

    List<PurchaseRecord> getPurchasesByCustomer(Long customerId);

    List<PurchaseRecord> getAllPurchases();

    Optional<PurchaseRecord> getPurchaseById(Long id);
}
