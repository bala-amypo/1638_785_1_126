// package com.example.demo.repository;
// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.CustomerProfile;
// @Repository
// public interface CustomerProfileRepository extends JpaRepository<CustomerProfile,Long>{
    
// CustomerProfile findByCustomerId(String customerId);
// }
package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerProfile;

@Repository
public interface CustomerProfileRepository
        extends JpaRepository<CustomerProfile, Long> {

    Optional<CustomerProfile> findByCustomerId(String customerId);

    Optional<CustomerProfile> findByEmail(String email);
}
