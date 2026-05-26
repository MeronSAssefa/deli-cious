package com.pluralsight.model;

public class Chips implements OrderItem {

    private String type;
    private double price;

    public Chips(String type) {
        this.type = type;
        this.price = 1.50;//price is the same for all
    }

    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
