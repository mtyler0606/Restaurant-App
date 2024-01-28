package com.example.restaurant.service;

import com.example.restaurant.domain.Order;
import com.example.restaurant.domain.Sandwich;

import java.util.List;

public interface OrderService {
    public List<Order> findAll();
    public Order findById(int theId);
    public void save (Order order);
    public void deleteById(int theId);
    public List<Order> listAll(String keyword);
}
