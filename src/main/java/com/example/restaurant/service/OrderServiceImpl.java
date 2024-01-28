package com.example.restaurant.service;

import com.example.restaurant.domain.Order;
import com.example.restaurant.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepo.findAll();
    }

    @Override
    public Order findById(int theId) {
        Optional<Order> result= orderRepo.findById((long)theId);
        Order order = null;
        if(result.isPresent()){
            order = result.get();
        }
        return order;
    }

    @Override
    public void save(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void deleteById(int theId) {
        orderRepo.deleteById((long)theId);
    }


    @Override
    public List<Order> listAll(String keyword) {
        if (keyword != null){
            return orderRepo.search(keyword);
        }
        return (List<Order>) orderRepo.findAll();
    }
}
