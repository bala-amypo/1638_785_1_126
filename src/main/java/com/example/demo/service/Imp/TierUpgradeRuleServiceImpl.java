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
 public TierUpgradeRule postdata(TierUpgradeRule stu){
    return tierUpgradeRuleRepository.save(stu);
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
 public  TierUpgradeRule updateData(int id,TierUpgradeRule entity){
    if(student.existsById(id)){
        entity.setId(id);
        return tierUpgradeRuleRepository.save(entity);
    }
     return null;
 }
}
