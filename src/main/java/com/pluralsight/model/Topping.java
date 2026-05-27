package com.pluralsight.model;

public class Topping {

    private String name;
    private String category;
    private boolean extra;
    private double price;

    public Topping(String name, String category, boolean extra, double price) {
        this.name = name;
        this.category = category;
        this.extra = extra;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPrice() {
        return price;
    }
}
