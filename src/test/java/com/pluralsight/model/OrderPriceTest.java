package com.pluralsight.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderPriceTest {

    @Test
    public void smallSandwich_shouldHaveBasePrice550() {
        Sandwich sandwich = new SmallSandwich("White");

        assertEquals(5.50, sandwich.getPrice(), 0.01);
    }

    @Test
    public void mediumSandwich_shouldHaveBasePrice700() {
        Sandwich sandwich = new MediumSandwich("Wheat");

        assertEquals(7.00, sandwich.getPrice(), 0.01);
    }

    @Test
    public void largeSandwich_shouldHaveBasePrice850() {
        Sandwich sandwich = new LargeSandwich("Rye");

        assertEquals(8.50, sandwich.getPrice(), 0.01);
    }

    @Test
    public void sandwichWithToppings_shouldAddToppingPrices() {
        Sandwich sandwich = new SmallSandwich("White");

        sandwich.addTopping(new Topping("Steak", "Meat", false, 1.00));
        sandwich.addTopping(new Topping("Cheddar", "Cheese", false, 0.75));

        assertEquals(7.25, sandwich.getPrice(), 0.01);
    }

    @Test
    public void orderTotal_shouldAddAllItems() {
        Order order = new Order();

        Sandwich sandwich = new SmallSandwich("White");
        sandwich.addTopping(new Topping("Steak", "Meat", false, 1.00));

        Drink drink = new Drink("Small", "Coke");
        Chips chips = new Chips("BBQ");

        order.addSandwich(sandwich);
        order.addDrink(drink);
        order.addChip(chips);

        assertEquals(10.00, order.getTotal(), 0.01);
    }
}
