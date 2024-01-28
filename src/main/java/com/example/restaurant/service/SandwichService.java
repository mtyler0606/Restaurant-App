package com.example.restaurant.service;

import com.example.restaurant.domain.Sandwich;

import java.util.List;

public interface SandwichService {
    public List<Sandwich> findAll();
    public Sandwich findById(int theId);
    public void save (Sandwich sandwich);
    public void deleteById(int theId);
    public List<Sandwich> listAll(String keyword);
}
