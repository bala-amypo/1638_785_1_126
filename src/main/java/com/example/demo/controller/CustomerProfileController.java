package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import java.util.List;

@RestController
public class CustomerProfileController{
    @Autowired CustomerProfileService customerProfileService;
@PostMapping("/api/customer")
public CustomerProfile dopost(@RequestBody CustomerProfile customer){
    return customerProfileService.createCustomer(customer);
}
@GetMapping("/api/customer")
public List<CustomerProfile>getval(){
    return customerProfileService.getAllCustomers();
}
@GetMapping("/api/customer/{id}")
public CustomerProfile getdataid(@PathVariable Long id){
   return customerProfileService.getCustomerById(id);
}
@PutMapping ("/put/{id}")
public CustomerProfile putval(@PathVariable int id, @RequestBody CustomerProfile entity){
 return customerProfileService.updateData(id,entity);
}
}
