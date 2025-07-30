package com.bek.DentalClinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="product_name")
    private String productName;

    private String description;

    @Column(name="unit_price")
    private Integer unitPrice;

    @Column(name="quantity_available")
    private Integer quantityAvailable;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    public Product(String productName, String description, Integer unitPrice, Integer quantityAvailable)
    {
        this.productName=productName;
        this.description=description;
        this.unitPrice=unitPrice;
        this.quantityAvailable=quantityAvailable;
    }
}
