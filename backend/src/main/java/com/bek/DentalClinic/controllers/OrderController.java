package com.bek.DentalClinic.controllers;

import com.bek.DentalClinic.models.Order;
import com.bek.DentalClinic.services.OrderService;
import com.bek.DentalClinic.viewModels.OrderVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order addOrder(@RequestBody OrderVM order)
    {
        return orderService.addOrder(order);
    }

    @GetMapping
    public ResponseEntity<Page<Order>> getAllOrders(
            @RequestParam (defaultValue = "0") Integer page,
            @RequestParam (defaultValue = "1") Integer size,
            @RequestParam (defaultValue = "id") String sortBy
    )
    {
        Page<Order> orders=orderService.getAllOrders(page,size,sortBy);
        return (orders!=null && !orders.isEmpty()) ? ResponseEntity.ok(orders):ResponseEntity.notFound().build();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Integer id)
    {
        Order order=orderService.getOrder(id);
        return (order!=null) ? ResponseEntity.ok(order):ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{id}")
    public void deleteOrder(@PathVariable Integer id)
    {
        orderService.deleteOrder(id);
    }
}
