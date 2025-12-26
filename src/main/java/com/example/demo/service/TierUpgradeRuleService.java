// package com.example.demo.service;
// import com.example.demo.entity.TierUpgradeRule;
// import java.util.List;
// public interface TierUpgradeRuleService{
//    TierUpgradeRule createRule(TierUpgradeRule rule);
//    TierUpgradeRule updateRule(Long id,TierUpgradeRule updatedRule);
//     List<TierUpgradeRule> getActiveRules();
//     List<TierUpgradeRule> getAllRules();
//     TierUpgradeRule getRule(String fromTier, String toTier);
// }
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.TierUpgradeRule;

public interface TierUpgradeRuleService {

    TierUpgradeRule createRule(TierUpgradeRule rule);

    TierUpgradeRule updateRule(Long id, TierUpgradeRule rule);

    List<TierUpgradeRule> getActiveRules();

    Optional<TierUpgradeRule> getRule(String fromTier, String toTier);

    List<TierUpgradeRule> getAllRules();
}

