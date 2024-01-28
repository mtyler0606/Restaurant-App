package com.example.restaurant.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Sandwiches")
public class Sandwich {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Min(value = 0, message = "Price value must be positive")
    private double basePrice;
    private double totalPrice;
    @ManyToOne
    private Order order;



    private String bread;
    private String protein;
    private String sauce;
    private String cheese;
    private boolean lettuce;
    private boolean tomato;
    private boolean pickles;
    private boolean completed;
    private int helper;

    public Sandwich() {
    }

    public Sandwich(Order order) {
        this.order = order;
    }

    public Sandwich(Order order, String bread, String protein, String sauce, String cheese, boolean lettuce, boolean tomato, boolean pickles, boolean completed) {
        this.order = order;
        this.bread = bread;
        this.protein = protein;
        this.sauce = sauce;
        this.cheese = cheese;
        this.lettuce = lettuce;
        this.tomato = tomato;
        this.pickles = pickles;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return "Sandwich No. " + this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }




    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }



    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public boolean isPickles() {
        return pickles;
    }

    public void setPickles(boolean pickles) {
        this.pickles = pickles;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getHelper() {
        return helper;
    }

    public void setHelper(int helper) {
        this.helper = helper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sandwich sandwich = (Sandwich) o;
        return id == sandwich.id && Double.compare(basePrice, sandwich.basePrice) == 0 && Double.compare(totalPrice, sandwich.totalPrice) == 0 && lettuce == sandwich.lettuce && tomato == sandwich.tomato && pickles == sandwich.pickles && completed == sandwich.completed && Objects.equals(name, sandwich.name) && Objects.equals(order, sandwich.order) && Objects.equals(bread, sandwich.bread) && Objects.equals(protein, sandwich.protein) && Objects.equals(sauce, sandwich.sauce) && Objects.equals(cheese, sandwich.cheese);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, basePrice, totalPrice, order, bread, protein, sauce, cheese, lettuce, tomato, pickles, completed);
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", totalPrice=" + totalPrice +
                ", order=" + order +
                ", bread='" + bread + '\'' +
                ", protein='" + protein + '\'' +
                ", sauce='" + sauce + '\'' +
                ", cheese='" + cheese + '\'' +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                ", pickles=" + pickles +
                ", completed=" + completed +
                '}';
    }
}
