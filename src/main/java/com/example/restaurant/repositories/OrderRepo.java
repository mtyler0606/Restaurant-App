package com.example.restaurant.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.restaurant.domain.Order;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.name LIKE %?1%")
    public List<Order> search(String keyword);
}
