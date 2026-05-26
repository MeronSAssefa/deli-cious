package com.pluralsight.model;

public class Sandwich implements OrderItem{

    private String size;
    private String bread;
    private double price;

    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;

        if (size.equalsIgnoreCase("4")) {
            this.price = 5.50;
        } else if (size.equalsIgnoreCase("8")) {
            this.price = 7.00;
        } else if (size.equalsIgnoreCase("12")) {
            this.price = 8.50;
        } else {
            this.price = 0.00;
        }
    }

    public String getSize() {
        return size;
    }

    public String getBread() {
        return bread;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
