package com.example.restaurant.service;

import com.example.restaurant.domain.Sandwich;
import com.example.restaurant.repositories.SandwichRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SandwichServiceImpl implements SandwichService {

    private SandwichRepo sandwichRepo;

    @Autowired
    public SandwichServiceImpl(SandwichRepo sandwichRepo) {
        this.sandwichRepo = sandwichRepo;
    }

    @Override
    public List<Sandwich> findAll() {
        return (List<Sandwich>) sandwichRepo.findAll();
    }

    @Override
    public Sandwich findById(int theId) {
        Optional<Sandwich> result = sandwichRepo.findById((long)theId);
        Sandwich sandwich = null;
        if(result.isPresent()){
            sandwich = result.get();
        }
        return sandwich;
    }

    @Override
    public void save(Sandwich sandwich) {
        if(sandwich.getOrder()!=null)sandwichRepo.save(sandwich);
    }

    @Override
    public void deleteById(int theId) {
        sandwichRepo.deleteById((long)theId);
    }

    @Override
    public List<Sandwich> listAll(String keyword) {
        if(keyword != null){
            return sandwichRepo.search(keyword);
        }
        return (List<Sandwich>) sandwichRepo.findAll();
    }
}
