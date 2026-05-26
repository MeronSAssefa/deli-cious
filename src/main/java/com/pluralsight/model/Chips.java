package com.pluralsight.model;

public class Chips {

    private String type;
    private double price;

    public Chips(String type) {
        this.type = type;
        this.price = 1.50;//price is the same for all
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
