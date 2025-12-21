package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TierUpgradeRule;
import java.util.List;
import java.util.Optional;

@Repository
public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {
    Optional<TierUpgradeRule> findByFromTierAndToTier(String fromTier, String toTier);
    List<TierUpgradeRule> findByActiveTrue();
}
