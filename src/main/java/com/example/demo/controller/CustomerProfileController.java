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
    @Autowired CustomerProfileService ser;
@PostMapping("/post")
public CustomerProfile dopost(@RequestBody CustomerProfile stu){
    return ser.postdata(stu);
}
@GetMapping("/get")
public List<CustomerProfile>getval(){
    return ser.getAllData();
}
@GetMapping("/getid/{id}")
public CustomerProfile getdataid(@PathVariable int id){
   return ser.getData(id);
}
@PutMapping ("/put/{id}")
public CustomerProfile putval(@PathVariable int id, @RequestBody CustomerProfile entity){
 return ser.updateData(id,entity);
}
}
