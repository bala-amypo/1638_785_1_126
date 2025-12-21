package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    @Autowired
    private TierUpgradeRuleService tierUpgradeRuleService;

  
    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return tierUpgradeRuleService.createRule(rule);
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleService.getAllRules();
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return tierUpgradeRuleService.getActiveRules();
    }

    @GetMapping("/{fromTier}/{toTier}")
    public TierUpgradeRule getRule(
            @PathVariable String fromTier,
            @PathVariable String toTier) {
        return tierUpgradeRuleService.getRule(fromTier, toTier);
    }

    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(
            @PathVariable Long id,
            @RequestBody TierUpgradeRule rule) {
        return tierUpgradeRuleService.updateRule(id, rule);
    }
}
