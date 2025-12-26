// package com.example.demo.service.Impl;

// import org.springframework.stereotype.Service;
// import com.example.demo.entity.CustomerProfile;
// import com.example.demo.entity.PurchaseRecord;
// import com.example.demo.entity.TierHistoryRecord;
// import com.example.demo.entity.TierUpgradeRule;
// import com.example.demo.repository.CustomerProfileRepository;
// import com.example.demo.repository.PurchaseRecordRepository;
// import com.example.demo.repository.VisitRecordRepository;
// import com.example.demo.repository.TierUpgradeRuleRepository;
// import com.example.demo.repository.TierHistoryRecordRepository;
// import com.example.demo.service.TierUpgradeEngineService;
// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {
//     private final CustomerProfileRepository customerProfileRepository;
//     private final PurchaseRecordRepository purchaseRecordRepository;
//     private final VisitRecordRepository visitRecordRepository;
//     private final TierUpgradeRuleRepository tierUpgradeRuleRepository;
//     private final TierHistoryRecordRepository tierHistoryRecordRepository;
//     public TierUpgradeEngineServiceImpl(
//             CustomerProfileRepository customerProfileRepository,
//             PurchaseRecordRepository purchaseRecordRepository,
//             VisitRecordRepository visitRecordRepository,
//             TierUpgradeRuleRepository tierUpgradeRuleRepository,
//             TierHistoryRecordRepository tierHistoryRecordRepository) {
//         this.customerProfileRepository = customerProfileRepository;
//         this.purchaseRecordRepository = purchaseRecordRepository;
//         this.visitRecordRepository = visitRecordRepository;
//         this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
//         this.tierHistoryRecordRepository = tierHistoryRecordRepository;
//     }
//     @Override
//     public TierHistoryRecord evaluateAndUpgradeTier(Long customerId) {
//         CustomerProfile customer = customerProfileRepository.findById(customerId).orElse(null);
//         if (customer == null) {
//             return null;
//         }
//      double totalSpend =purchaseRecordRepository.findByCustomerId(customerId).stream().mapToDouble(PurchaseRecord::getAmount).sum();
//     long totalVisits = visitRecordRepository.findByCustomerId(customerId).size();
//     String currentTier = customer.getCurrentTier();
//      List<TierUpgradeRule> activeRules = tierUpgradeRuleRepository.findByActiveTrue();
// for (TierUpgradeRule rule : activeRules) {
//             if (rule.getFromTier().equals(currentTier) && totalSpend >= rule.getMinSpend()&& totalVisits >= rule.getMinVisits()) {
//                 customer.setCurrentTier(rule.getToTier());
//                 customerProfileRepository.save(customer);
//                 TierHistoryRecord history = new TierHistoryRecord();
//                 history.setCustomerId(customerId);
//                 history.setOldTier(currentTier);
//                 history.setNewTier(rule.getToTier());
//                 history.setReason("Upgrade criteria met");
//                 history.setChangedAt(LocalDateTime.now());
//                 return tierHistoryRecordRepository.save(history);
//             }
//         }

//         return null;
//     }

//     @Override
//     public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
//         return tierHistoryRecordRepository.findByCustomerId(customerId);
//     }

//     @Override
//     public List<TierHistoryRecord> getAllHistory() {
//         return tierHistoryRecordRepository.findAll();
//     }
// }
