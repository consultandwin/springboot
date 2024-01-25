package com.example.customermicroservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class customer {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="customer_address")
    private String customerAddress;

    @Column(name="customer_department")
    private String customerDepartment;
}
