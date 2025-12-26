// package com.example.demo.entity ;
// import java.time.LocalDateTime;
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
//  public class TierHistoryRecord{
//      @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private long customerId;
//     private String oldTier;
//     private String newTier;
//     private String reason;
//     private LocalDateTime changedAt;
//  }
 
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDate;

@Entity
@Table(name = "purchase_record")
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    private Double amount;
    private LocalDate purchaseDate;
    private String storeLocation;

    public PurchaseRecord() {}

    public void setId(Long id) { this.id = id; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setStoreLocation(String storeLocation) { this.storeLocation = storeLocation; }

    public void setCustomer(CustomerProfile customer) {
        this.customerId = customer.getId();
    }

    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public Double getAmount() { return amount; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public String getStoreLocation() { return storeLocation; }
}

