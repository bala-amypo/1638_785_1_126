package com.example.demo.entity ;
import java.time.LocalDateTime;
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
 public class TierHistoryRecord{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private long customerId;
    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;
 }
 
