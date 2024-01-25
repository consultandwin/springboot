package com.example.customermicroservice.controller;

import com.example.customermicroservice.dto.customerDto;
import com.example.customermicroservice.entity.customer;
import com.example.customermicroservice.exception.CustomerNotFoundException;
import com.example.customermicroservice.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class customerController {

    @Autowired
    private customerService service;

    @GetMapping("/customer")
    public List<customer> getAllCustomer()
    {
        return service.getAllCustomer();
    }
    @GetMapping("/customer/{id}")
    public Optional<customer> getCustomer(@PathVariable("id") int id)
    {
        return service.getCustomerById(id);
    }

    @PostMapping("/customer/createCustomer")
    public customer createCustomer(@RequestBody customer customer)
    {
        return service.saveCustomer(customer);
    }

    @PatchMapping("/customer/updateCustomerByFields/{id}")
    public customer updateCustomerByFields(@PathVariable int id,@RequestBody Map<String, Object> fields)
    {
        return service.updateCustomerByFields(id,fields);
    }

    @GetMapping("/customer/name/{id}")
    public customerDto getNameById(@PathVariable("id") int id) throws Exception {
        return service.getCustomerNameById(id);
    }

}
