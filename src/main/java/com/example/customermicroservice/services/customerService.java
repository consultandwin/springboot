package com.example.customermicroservice.services;

import com.example.customermicroservice.dto.customerDto;
import com.example.customermicroservice.entity.customer;
import com.example.customermicroservice.exception.CustomerNotFoundException;
import com.example.customermicroservice.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class customerService {
@Autowired
private customerRepository repository;
public List<customer> getAllCustomer()
{
    return repository.findAll();
}

public Optional<customer> getCustomerById(int id)
{
    return repository.findById(id);
}

public customer saveCustomer(customer customer)
{
    return repository.save(customer);
}

    public customer updateCustomerByFields(int id, Map<String, Object> fields) {
        Optional<customer> existingProduct = repository.findById(id);

        if (existingProduct.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(customer.class, key);
                assert field != null;
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingProduct.get(), value);
            });
            return repository.save(existingProduct.get());
        }
        return null;
    }

    public customerDto getCustomerNameById(int id) throws Exception {
        customer customer = null;
        customer=repository.findById(id).orElseThrow(() -> new CustomerNotFoundException("there is no customer with this id "+id));
        customerDto customerDto=null;
        if (customer != null) {
            customerDto = new customerDto();
            customerDto.setCustomerName(customer.getCustomerName());
        }
        return customerDto;
    }
}
