package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.CustomerProfile;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.CustomerProfileService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomerProfileService customerService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(CustomerProfileService customerService,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

//     @PostMapping("/register")
//     public ResponseEntity<ApiResponse<CustomerProfile>> register(
//             @RequestBody RegisterRequest request) {

//         CustomerProfile customer = new CustomerProfile();
//         customer.setCustomerId(request.getEmail()); // using email as ID
//         customer.setEmail(request.getEmail());
//         customer.setFullName(request.getFullName());
//         customer.setPhone(request.getPhone());
//         customer.setCurrentTier("BRONZE");
//         customer.setActive(true);


        @PostMapping("/register")
public CustomerProfile register(@RequestBody RegisterRequest req) {

    CustomerProfile c = new CustomerProfile();
    c.setEmail(req.getEmail());
    c.setCustomerId(req.getEmail());
    c.setFullName(req.getFullName());
    c.setPhone(req.getPhone());
    c.setRole("USER");
    c.setPassword(passwordEncoder.encode(req.getPassword()));
    c.setActive(true);
    c.setCurrentTier("BRONZE");

    return customerService.createCustomer(c);
}


        CustomerProfile saved = customerService.createCustomer(customer);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "User registered", saved)
        );
    }

//     @PostMapping("/login")
//     public ResponseEntity<ApiResponse<String>> login(
//             @RequestBody LoginRequest request) {

//         CustomerProfile customer =
//                 customerService.findByCustomerId(request.getEmail())
//                         .orElseThrow(() ->
//                                 new IllegalArgumentException("Invalid credentials"));

//         String token = jwtUtil.generateToken(
//                 customer.getId(),
//                 customer.getEmail(),
//                 "USER"
//         );

//         return ResponseEntity.ok(
//                 new ApiResponse<>(true, "Login successful", token)
//         );
@PostMapping("/login")
public AuthResponse login(@RequestBody AuthRequest request) {

    CustomerProfile customer =
            customerService.findByCustomerId(request.getEmail())
                    .orElseThrow(() ->
                        new RuntimeException("User not found"));

    if (!passwordEncoder.matches(
            request.getPassword(),
            customer.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }

    String token =
            jwtUtil.generateToken(
                    customer.getEmail(),
                    customer.getRole()
            );

    return new AuthResponse(token, customer.getRole());
}
        }
   // }

