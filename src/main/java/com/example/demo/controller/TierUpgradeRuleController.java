// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import com.example.demo.entity.TierUpgradeRule;
// import com.example.demo.service.TierUpgradeRuleService;
// import java.util.List;

// @RestController
// @RequestMapping("/api/tier-rules")
// public class TierUpgradeRuleController {
//     @Autowired
//     private TierUpgradeRuleService tierUpgradeRuleService;
//     @PostMapping
//     public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
//         return tierUpgradeRuleService.createRule(rule);
//     }
//     @PutMapping("/{id}")
//     public TierUpgradeRule updateRule( @PathVariable Long id, @RequestBody TierUpgradeRule rule) {
//         return tierUpgradeRuleService.updateRule(id, rule);
//     }
//     @GetMapping("/active")
//     public List<TierUpgradeRule> getActiveRules() {
//         return tierUpgradeRuleService.getActiveRules();
//     }
//     @GetMapping
//     public List<TierUpgradeRule> getAllRules() {
//         return tierUpgradeRuleService.getAllRules();
//     }
//     @GetMapping("/lookup")
//     public TierUpgradeRule getRule(
//             @RequestParam String fromTier,
//             @RequestParam String toTier) {
//         return tierUpgradeRuleService.getRule(fromTier, toTier);
//     }
// }
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TierUpgradeRule create(@RequestBody TierUpgradeRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRule update(
            @PathVariable Long id,
            @RequestBody TierUpgradeRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping
    public List<TierUpgradeRule> getAll() {
        return service.getAllRules();
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActive() {
        return service.getActiveRules();
    }

    @GetMapping("/lookup")
    public Optional<TierUpgradeRule> lookup(
            @RequestParam String fromTier,
            @RequestParam String toTier) {
        return service.getRule(fromTier, toTier);
    }
}
