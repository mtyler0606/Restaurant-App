package com.example.restaurant.repositories;

import com.example.restaurant.domain.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepo extends CrudRepository<Ingredient, Long> {
    @Query("SELECT i FROM Ingredient i WHERE i.name LIKE %?1%")
    public List<Ingredient> search(String keyword);
}
