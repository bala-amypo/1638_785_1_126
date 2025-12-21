package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.TierUpgradeRuleService;
import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import java.util.List;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {
    @Autowired TierUpgradeRuleRepository tierUpgradeRuleRepository;
    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return tierUpgradeRuleRepository.save(rule);
    }
    @Override
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleRepository.findAll();
    }
    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return tierUpgradeRuleRepository.findByActiveTrue();
    }

    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return tierUpgradeRuleRepository
                .findByFromTierAndToTier(fromTier, toTier);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {
        TierUpgradeRule existing =
                tierUpgradeRuleRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setFromTier(updatedRule.getFromTier());
            existing.setToTier(updatedRule.getToTier());
            existing.setActive(updatedRule.isActive());
            existing.setMinPoints(updatedRule.getMinPoints());

            return tierUpgradeRuleRepository.save(existing);
        }
        return null;
    }
}
