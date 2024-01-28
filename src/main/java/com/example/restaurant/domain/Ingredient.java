package com.example.restaurant.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Invalid Price: Price value must be positive")
    double price;
    @Min(value = 0, message = "Invalid Inventory Value: must be positive")
    int inv;



    public Ingredient() {
    }

    public Ingredient(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }


    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inv=" + inv +
                '}';
    }
}
