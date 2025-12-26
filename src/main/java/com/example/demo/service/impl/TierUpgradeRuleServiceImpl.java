// package com.example.demo.service.Impl;

// import org.springframework.stereotype.Service;
// import com.example.demo.service.TierUpgradeRuleService;
// import com.example.demo.entity.TierUpgradeRule;
// import com.example.demo.repository.TierUpgradeRuleRepository;
// import java.util.List;

// @Service
// public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {
//     private final TierUpgradeRuleRepository tierUpgradeRuleRepository;
//     public TierUpgradeRuleServiceImpl(
//             TierUpgradeRuleRepository tierUpgradeRuleRepository) {
//         this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
//     }
//     @Override
//     public TierUpgradeRule createRule(TierUpgradeRule rule) {
//         if (rule.getMinSpend() < 0 || rule.getMinVisits() < 0) {
//             return null;
//         }
//         return tierUpgradeRuleRepository.save(rule);
//     }
//     @Override
//     public List<TierUpgradeRule> getAllRules() {
//         return tierUpgradeRuleRepository.findAll();
//     }
//     @Override
//     public List<TierUpgradeRule> getActiveRules() {
//         return tierUpgradeRuleRepository.findByActiveTrue();
//     }
//     @Override
//     public TierUpgradeRule getRule(String fromTier, String toTier) {
//         return tierUpgradeRuleRepository
//                 .findByFromTierAndToTier(fromTier, toTier)
//                 .orElse(null);   
//     }
//     @Override
//     public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {
//         TierUpgradeRule existing =tierUpgradeRuleRepository.findById(id).orElse(null);
//         if (existing == null) {
//             return null;
//         }
//         if (updatedRule.getMinSpend() < 0 || updatedRule.getMinVisits() < 0) {
//             return null;
//         }
//         existing.setFromTier(updatedRule.getFromTier());
//         existing.setToTier(updatedRule.getToTier());
//         existing.setMinSpend(updatedRule.getMinSpend());   
//         existing.setMinVisits(updatedRule.getMinVisits()); 
//         existing.setActive(updatedRule.isActive());
//         return tierUpgradeRuleRepository.save(existing);
//     }
// }
package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        if (rule.getMinSpend() < 0 || rule.getMinVisits() < 0) {
            throw new IllegalArgumentException("Invalid rule values");
        }
        return repository.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updated) {
        TierUpgradeRule existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        existing.setFromTier(updated.getFromTier());
        existing.setToTier(updated.getToTier());
        existing.setMinSpend(updated.getMinSpend());
        existing.setMinVisits(updated.getMinVisits());
        existing.setActive(updated.getActive());

        return repository.save(existing);
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public Optional<TierUpgradeRule> getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier);
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }
}

