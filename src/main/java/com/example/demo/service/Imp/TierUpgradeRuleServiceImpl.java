package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.TierUpgradeRuleService;
import  com.example.demo.entity.TierUpgradeRule;
import  com.example.demo.repository.TierUpgradeRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService{
      @Autowired TierUpgradeRuleRepository tierUpgradeRuleRepository;
 public TierUpgradeRule createRule(TierUpgradeRule rule){
    return tierUpgradeRuleRepository.save(rule);
 }
 @Override
 public List<TierUpgradeRule> getAllData(){
      return tierUpgradeRuleRepository.findAll();
 }
 @Override
 public  TierUpgradeRule getData(int id){
    return tierUpgradeRuleRepository.findById(id).orElse(null);
 }
 @Override
 public  TierUpgradeRule updateRule(Long id,TierUpgradeRule updateRule){
    if(student.existsById(id)){
        entity.setId(id);
        return tierUpgradeRuleRepository.save(updateRule);
    }
     return null;
 }
}
