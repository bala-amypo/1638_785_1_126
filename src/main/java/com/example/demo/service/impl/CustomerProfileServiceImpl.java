
package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        return customerProfileRepository.save(customer);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileRepository.findAll();
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return customerProfileRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerProfile findByCustomerId(String customerId) {
        return customerProfileRepository.findByCustomerId(customerId);
    }

    @Override
    public CustomerProfile updateTier(Long id, String currentTier) {
        CustomerProfile customer = customerProfileRepository.findById(id).orElse(null);

        if (customer != null) {
            customer.setCurrentTier(currentTier);
            return customerProfileRepository.save(customer);
        }
        return null;
    }

    @Override
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile customer = customerProfileRepository.findById(id).orElse(null);

        if (customer != null) {
            customer.setActive(active);
            return customerProfileRepository.save(customer);
        }
        return null;
    }
}
