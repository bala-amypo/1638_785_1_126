package com.example.demo.entity


 public class CustomerProfileModel{
    

 }
 package com.example.demo.entity ;
import java.util.Date;
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
public class CustomerProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    } 
