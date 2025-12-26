package com.example.demo.entity ;
import java.time.LocalDate;
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
 public class VisitRecord{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private long customerId;
    private LocalDate visitDate;
    private String channel;
 }
 
