package com.example.restaurant.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    Ingredient ingredient;
    @BeforeEach
    void setUp() { ingredient = new Ingredient();
    }

    @Test
    void getId() {
        long id = 5;
        ingredient.setId(id);
        assertEquals(id, ingredient.getId());
    }

    @Test
    void setId() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void setPrice() {
    }

    @Test
    void getInv() {
    }

    @Test
    void setInv() {
    }
}