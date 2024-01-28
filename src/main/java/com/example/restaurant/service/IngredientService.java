package com.example.restaurant.service;

import com.example.restaurant.domain.Ingredient;

import java.util.List;

public interface IngredientService {
    public List<Ingredient> findAll();
    public Ingredient findById(int theId);
    public void save (Ingredient ingredient);
    public void deleteById(int theId);
    public List<Ingredient> listAll(String keyword);
}
