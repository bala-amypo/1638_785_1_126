// package com.example.demo.service;
// import com.example.demo.entity.CustomerProfile;
// import java.util.List;
// public interface CustomerProfileService{
//     CustomerProfile createCustomer(CustomerProfile customer);
//     List<CustomerProfile> getAllCustomers();
//     CustomerProfile getCustomerById(Long id);
//     CustomerProfile findByCustomerId(String customerId);
//     CustomerProfile updateTier(Long id,String currentTier);
//     CustomerProfile updateStatus(Long id,boolean active);
// }
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.CustomerProfile;

public interface CustomerProfileService {

    CustomerProfile createCustomer(CustomerProfile customer);

    CustomerProfile getCustomerById(Long id);

    Optional<CustomerProfile> findByCustomerId(String customerId);

    List<CustomerProfile> getAllCustomers();

    CustomerProfile updateTier(Long id, String newTier);

    CustomerProfile updateStatus(Long id, boolean active);
}

