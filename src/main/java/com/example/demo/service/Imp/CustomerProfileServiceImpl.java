package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.CustomerProfileService;
import  com.example.demo.entity.CustomerProfile;
import  com.example.demo.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService{
      @Autowired CustomerProfileRepository customerProfileRepository;
      @Override
 public CustomerProfile createCustomer(CustomerProfile customer){
    return customerProfileRepository.save(customer);
 }
 @Override
 public List<CustomerProfile> getAllCustomers(){
      return customerProfileRepository.findAll();
 }
 @Override
 public  CustomerProfile getCustomerById(Long id){
    return customerProfileRepository.findById(id).orElse(null);
 }
  @Override
 public  CustomerProfile findByCustomerId(String customerId){
    return customerProfileRepository.findById(customerId).orElse(null);
 }
 @Override
 public  CustomerProfile updateTier(Long id,String newTier){
    if(customerProfileRepository.existsById(id)){
        entity.setId(id);
        return customerProfileRepository.save(entity);
    }
     return null;
 }
}
