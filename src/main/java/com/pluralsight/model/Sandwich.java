package com.pluralsight.model;

import java.util.ArrayList;

public abstract class Sandwich implements OrderItem{

    private String size;
    private String bread;
    private double price;
    private ArrayList<Topping> toppings;
    private boolean toasted;

    public Sandwich(String size, String bread,double price) {
        this.size = size;
        this.bread = bread;
        this.price = price;
        this.toppings = new ArrayList<>();
        this.toasted = false;
        
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

        double total = price;

        for (Topping topping : toppings) {
            total += topping.getPrice();
        }

        return total;
    }
}
