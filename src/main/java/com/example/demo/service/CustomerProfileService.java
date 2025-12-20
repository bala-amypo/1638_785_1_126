package com.example.demo.service;
import com.example.demo.entity.CustomerProfile;
import java.util.List;
public interface CustomerProfileService{
    CustomerProfile createCustomer(CustomerProfile customer);
    List<CustomerProfile> getAllCustomers();
    CustomerProfile getCustomerById(Long id);
    CustomerProfile findByCustomerId(String customerid);
    CustomerProfile updateTier(Long id,String newTier);
    CustomerProfile updateStatus(Long id,boolean active);
}
