package com.example.demo.entity ;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
 public class TierUpgradeRule{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fromTier;
    private String toTier;
    private double minSpend;
    private int minVisits ;
    private boolean active;
 }
 
