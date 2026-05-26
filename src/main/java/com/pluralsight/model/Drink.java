package com.pluralsight.model;

public class Drink {

    private String Size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.Size = size;
        this.flavor = flavor;

        if (size.equalsIgnoreCase("small")) {
            this.price = 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            this.price = 2.50;
        } else if (size.equalsIgnoreCase("large")) {
            this.price = 3.00;
        } else {
            this.price = 0.00;
        }

    }

    public String getSize() {
        return Size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }
}
