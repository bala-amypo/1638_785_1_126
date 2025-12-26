// package com.example.demo.entity ;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
//  public class TierUpgradeRule{
//      @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String fromTier;
//     private String toTier;
//     private double minSpend;
//     private int minVisits ;
//     private boolean active;
//  }
 
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

@Entity
@Table(name = "tier_history_record")
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;

    public TierHistoryRecord() {}

    public TierHistoryRecord(Long customerId,
                             String oldTier,
                             String newTier,
                             String reason,
                             LocalDateTime changedAt) {
        this.customerId = customerId;
        this.oldTier = oldTier;
        this.newTier = newTier;
        this.reason = reason;
        this.changedAt = changedAt;
    }

    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public String getOldTier() { return oldTier; }
    public String getNewTier() { return newTier; }
    public String getReason() { return reason; }
    public LocalDateTime getChangedAt() { return changedAt; }

    public void setId(Long id) { this.id = id; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public void setOldTier(String oldTier) { this.oldTier = oldTier; }
    public void setNewTier(String newTier) { this.newTier = newTier; }
    public void setReason(String reason) { this.reason = reason; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }
}

