package com.example.customermicroservice.repository;

import com.example.customermicroservice.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<customer, Integer> {

}
