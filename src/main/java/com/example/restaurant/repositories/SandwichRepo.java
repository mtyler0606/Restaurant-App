package com.example.restaurant.repositories;

import com.example.restaurant.domain.Sandwich;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SandwichRepo extends CrudRepository<Sandwich, Long> {
    @Query("SELECT s FROM Sandwich s WHERE s.name LIKE %?1%")
    public List<Sandwich> search(String keyword);
}
