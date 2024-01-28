package com.example.restaurant.bootstrap;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.Order;
import com.example.restaurant.domain.Sandwich;
import com.example.restaurant.repositories.IngredientRepo;
import com.example.restaurant.repositories.OrderRepo;
import com.example.restaurant.repositories.SandwichRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    //private final IngredientRepo ingredientRepo;
    private final SandwichRepo sandwichRepo;
    private final OrderRepo orderRepo;

    public BootstrapData(SandwichRepo sandwichRepo, OrderRepo orderRepo) {
        //this.ingredientRepo = ingredientRepo;
        this.sandwichRepo = sandwichRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public void run(String... args) throws Exception {


        Order o1 = new Order(1);
        Order o2 = new Order(2);
        Order o3 = new Order(3);
        Order o4 = new Order(4);



        Sandwich s1 = new Sandwich(o1, "sourdough", "chicken", "mayo", "cheddar", true, false, true, false);
        o1.getSandwiches().add(s1);
        Sandwich s2 = new Sandwich(o1, "sourdough", "pork", "mayo", "cheddar", true, false, true, false);
        o1.getSandwiches().add(s2);
        Sandwich s3 = new Sandwich(o2, "wrap", "chicken", "mayo", "swiss", true, false, true, false);
        o2.getSandwiches().add(s3);
        Sandwich s4 = new Sandwich(o3, "sourdough", "shrimp", "mayo", "cheddar", true, false, true, false);
        o3.getSandwiches().add(s4);
        orderRepo.save(o1);
        orderRepo.save(o2);
        orderRepo.save(o3);
        orderRepo.save(o4);
        sandwichRepo.save(s1);
        sandwichRepo.save(s2);
        sandwichRepo.save(s3);
        sandwichRepo.save(s4);



        System.out.println(sandwichRepo.count());
        System.out.println(sandwichRepo.findAll());
        System.out.println(orderRepo.findAll());
    }
}
