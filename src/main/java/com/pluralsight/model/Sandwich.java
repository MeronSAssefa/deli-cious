package com.pluralsight.model;

import java.util.ArrayList;

public class Sandwich implements OrderItem{

    private String size;
    private String bread;
    private double price;
    private ArrayList<Topping> toppings;
    private boolean toasted;

    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.toasted = false;

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
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
