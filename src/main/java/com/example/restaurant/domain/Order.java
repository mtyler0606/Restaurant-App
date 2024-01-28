package com.example.restaurant.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String name;
    @Min(value = 0, message = "Total value must be positive")
    private double total;
    private boolean completed;
    @OneToMany(cascade= CascadeType.ALL, mappedBy = "order")
    private Set<Sandwich> sandwiches= new HashSet<>();

    public Order() {
    }

    public Order(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Order No. " + this.id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Set<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(Set<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(total, order.total) == 0 && Objects.equals(sandwiches, order.sandwiches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                '}';
    }
}
