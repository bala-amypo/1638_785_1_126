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
