// package com.example.demo.service;
// import com.example.demo.entity.TierHistoryRecord;
// import java.util.List;

// public interface TierUpgradeEngineService {
//     TierHistoryRecord evaluateAndUpgradeTier(Long customerId);
//     List<TierHistoryRecord> getHistoryByCustomer(Long customerId);
//     List<TierHistoryRecord> getAllHistory();
// }
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TierHistoryRecord;

public interface TierUpgradeEngineService {

    TierHistoryRecord evaluateAndUpgradeTier(Long customerId);

    List<TierHistoryRecord> getHistoryByCustomer(Long customerId);

    List<TierHistoryRecord> getAllHistory();
}


