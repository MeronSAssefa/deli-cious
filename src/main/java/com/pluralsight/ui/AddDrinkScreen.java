package com.pluralsight.ui;

import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;

import java.util.Scanner;

public class AddDrinkScreen {

    public void addDrinkToOrder(Order currentOrder) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What size drink would you like?");
        System.out.println("Small");
        System.out.println("Medium");
        System.out.println("Large");
        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        System.out.print("What flavor drink would you like? ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);

        currentOrder.addDrink(drink);

        System.out.println(size + " " + flavor + " drink added to your order.");
    }
}
