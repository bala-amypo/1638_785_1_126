// package com.example.demo.controller;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import com.example.demo.entity.CustomerProfile;
// import com.example.demo.service.CustomerProfileService;
// import java.util.List;

// @RestController
// public class CustomerProfileController{
//     @Autowired CustomerProfileService customerProfileService;
// @PostMapping("/api/customer")
// public CustomerProfile dopost(@RequestBody CustomerProfile customer){
//     return customerProfileService.createCustomer(customer);
// }
// @GetMapping("/api/customer")
// public List<CustomerProfile>getval(){
//     return customerProfileService.getAllCustomers();
// }
// @GetMapping("/api/customer/{id}")
// public CustomerProfile getdataid(@PathVariable Long id){
//    return customerProfileService.getCustomerById(id);
// }
// @GetMapping("/api/customer/lookup/{customerId}")
// public CustomerProfile getdataid(@PathVariable String customerId){
//    return customerProfileService.findByCustomerId(customerId);
// }
// @PutMapping ("/api/customer/{id}/tier")
// public CustomerProfile putval(@PathVariable long id, @RequestBody String newTier){
//  return customerProfileService.updateTier(id,newTier);
// }
// @PutMapping ("/api/customer/{id}/status")
// public CustomerProfile putval(@PathVariable long id, @RequestBody boolean active){
//  return customerProfileService.updateStatus(id,active);
// }
// }
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerProfile create(@RequestBody CustomerProfile customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfile getById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerProfile> getAll() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(
            @PathVariable Long id,
            @RequestParam String newTier) {
        return service.updateTier(id, newTier);
    }

    @PutMapping("/{id}/status")
    public CustomerProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateStatus(id, active);
    }

    @GetMapping("/lookup/{customerId}")
    public Optional<CustomerProfile> findByCustomerId(
            @PathVariable String customerId) {
        return service.findByCustomerId(customerId);
    }
}
