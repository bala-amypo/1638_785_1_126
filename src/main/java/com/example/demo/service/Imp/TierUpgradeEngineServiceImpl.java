package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.entity.PurchaseRecord;
import com.example.demo.entity.TierHistoryRecord;
import com.example.demo.entity.TierUpgradeRule;

import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.repository.TierHistoryRecordRepository;

import com.example.demo.service.TierUpgradeEngineService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerProfileRepository;
    private final PurchaseRecordRepository purchaseRecordRepository;
    private final VisitRecordRepository visitRecordRepository;
    private final TierUpgradeRuleRepository tierUpgradeRuleRepository;
    private final TierHistoryRecordRepository tierHistoryRecordRepository;

    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerProfileRepository,
            PurchaseRecordRepository purchaseRecordRepository,
            VisitRecordRepository visitRecordRepository,
            TierUpgradeRuleRepository tierUpgradeRuleRepository,
            TierHistoryRecordRepository tierHistoryRecordRepository) {

        this.customerProfileRepository = customerProfileRepository;
        this.purchaseRecordRepository = purchaseRecordRepository;
        this.visitRecordRepository = visitRecordRepository;
        this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
        this.tierHistoryRecordRepository = tierHistoryRecordRepository;
    }

    @Override
    public TierHistoryRecord evaluateAndUpgradeTier(Long customerId) {

        // 1️⃣ Get customer
        CustomerProfile customer =
                customerProfileRepository.findById(customerId).orElse(null);

        if (customer == null) {
            return null;
        }

        // 2️⃣ Calculate total spend
        double totalSpend =
                purchaseRecordRepository.findByCustomerId(customerId)
                        .stream()
                        .mapToDouble(PurchaseRecord::getAmount)
                        .sum();

        // 3️⃣ Calculate total visits
        long totalVisits =
                visitRecordRepository.findByCustomerId(customerId).size();

        // 4️⃣ Get current tier
        String currentTier = customer.getCurrentTier();

        // 5️⃣ Get active rules
        List<TierUpgradeRule> activeRules =
                tierUpgradeRuleRepository.findByActiveTrue();

        // 6️⃣ Evaluate rules
        for (TierUpgradeRule rule : activeRules) {

            if (rule.getFromTier().equals(currentTier)
                    && totalSpend >= rule.getMinSpend()
                    && totalVisits >= rule.getMinVisits()) {

                // Upgrade customer tier
                customer.setCurrentTier(rule.getToTier());
                customerProfileRepository.save(customer);

                // Create history record
                TierHistoryRecord history = new TierHistoryRecord();
                history.setCustomerId(customerId);
                history.setOldTier(currentTier);
                history.setNewTier(rule.getToTier());
                history.setReason("Upgrade criteria met");
                history.setChangedAt(LocalDateTime.now());

                return tierHistoryRecordRepository.save(history);
            }
        }

        // No upgrade happened
        return null;
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return tierHistoryRecordRepository.findByCustomerId(customerId);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return tierHistoryRecordRepository.findAll();
    }
}
