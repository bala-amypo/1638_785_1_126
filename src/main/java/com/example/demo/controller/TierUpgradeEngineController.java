package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import java.util.List;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {
@Autowired TierUpgradeEngineService tierUpgradeEngineService;
    @PostMapping("/evaluate/{customerId}")
    public TierHistoryRecord evaluateTier(@PathVariable long customerId) {
        return tierUpgradeEngineService .evaluateAndUpgradeTier(customerId);
    }
    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistoryByCustomer(@PathVariable Long customerId) {
     return tierUpgradeEngineService.getHistoryByCustomer(customerId);
    }
    @GetMapping
    public List<TierHistoryRecord> getAllHistory() {
        return tierUpgradeEngineService.getAllHistory();
    }
}
