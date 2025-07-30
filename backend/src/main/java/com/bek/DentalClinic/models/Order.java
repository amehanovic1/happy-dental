package com.bek.DentalClinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="order_date_time")
    private LocalDateTime orderDateTime;

    @Column(name="quantity_ordered")
    private Integer quantityOrdered;

    @Column(name="is_order_canceled", nullable = false, columnDefinition = "boolean default false")
    private boolean isOrderCanceled = false;

    @Column(name="is_order_confirmed", nullable = false, columnDefinition = "boolean default false")
    private boolean isOrderConfirmed = false;

    @Column(name="product_id")
    private Integer productId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_id",insertable = false,updatable = false)
    private Product product;

    @Column(name="user_id")
    private Integer userId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id",insertable=false,updatable=false)
    private User user;

    public Order(LocalDateTime orderDateTime, Integer quantityOrdered, Integer productId, Integer userId)
    {
        this.orderDateTime=orderDateTime;
        this.productId=productId;
        this.quantityOrdered=quantityOrdered;
        this.userId=userId;
    }

    public void confirmOrder(){
        isOrderConfirmed=true;
    }
    public void cancelOrder(){
        isOrderCanceled=true;
    }
}
