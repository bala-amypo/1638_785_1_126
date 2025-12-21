package com.example.demo.service;
import com.example.demo.entity.TierUpgradeRule;
import java.util.List;
public interface TierUpgradeRuleService{
   TierUpgradeRule createRule(TierUpgradeRule rule);
   TierUpgradeRule updateRule(Long id,TierUpgradeRule entity);
    List<TierUpgradeRule> getAllData();
    String deleteData(int id);
    TierUpgradeRule getData(int id);
    
}
