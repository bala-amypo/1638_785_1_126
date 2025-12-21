package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import java.util.List;

@RestController
public class TierUpgradeRuleController{
    @Autowired TierUpgradeRuleService tierUpgradeRuleService;
@PostMapping("/api/tier-rules")
public TierUpgradeRule dopost(@RequestBody TierUpgradeRule rule){
    return tierUpgradeRuleService.createRule(rule);
}
@PutMapping ("/api/tier-rules/{id}")
public TierUpgradeRule putval(@PathVariable Long id, @RequestBody rule){
 return tierUpgradeRuleService.updateRule(id,rule);
}
@GetMapping("/api/tier-rules")
public List<TierUpgradeRule>getval(){
    return tierUpgradeRuleService.getAllRules();
}
@GetMapping("/api/tier-rules/active")
public List<TierUpgradeRule>getval(){
    return tierUpgradeRuleService.getActiveRules();
}
@GetMapping("/api/tier-rules/lookup")
public TierUpgradeRule getdataid(@PathVariable int id){
   return tierUpgradeRuleService.getRule(fromTier,tiTier);
}

}
