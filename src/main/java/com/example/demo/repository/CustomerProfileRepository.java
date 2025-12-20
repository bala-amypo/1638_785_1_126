package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CustomerProfile;
@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile,Long>{
    

}
