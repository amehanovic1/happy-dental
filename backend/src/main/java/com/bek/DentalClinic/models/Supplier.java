package com.bek.DentalClinic.models;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String supplierName;

    public Supplier(){}

    public Supplier(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }
}
