package io.springlab.dynamodbtuto.controllers.customer;

import com.amazonaws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springlab.dynamodbtuto.entitys.customer.Customer;
import io.springlab.dynamodbtuto.services.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController  {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    private ResponseEntity<?> getMain(){
        return ResponseEntity.ok("Hi , i'm customer controller");
    }

    @PostMapping
    private ResponseEntity<?> setCustomer(@RequestBody Customer customer){
        System.out.println(customer.toString());
        
        return customerService.setCustomer(customer) ? new ResponseEntity<String>("customer added successfully", HttpStatus.OK) : ResponseEntity.ok("error while add customer");
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getCustomer(@PathVariable String id){
        
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteCusromer(@PathVariable String id){
        
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }
}
