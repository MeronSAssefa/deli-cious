package com.pluralsight.ui;

import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;

import java.util.Scanner;

public class AddDrinkScreen {

    Scanner scanner = new Scanner(System.in);
    public void addDrinkToOrder(Order currentOrder) {

        String sizeChoice = "";
        String size = "";

        boolean validSize = false;

        while (!validSize) {
            System.out.println("What size drink would you like?");
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");
            System.out.print("Choose size: ");

            sizeChoice = scanner.nextLine().strip();

            if (sizeChoice.equals("1") || sizeChoice.equals("2") || sizeChoice.equals("3")) {
                validSize = true;
            } else {
                System.out.println("Invalid size. Please choose 1, 2, or 3.");
            }
        }

        if (sizeChoice.equals("1")) {
            size = "Small";
        } else if (sizeChoice.equals("2")) {
            size = "Medium";
        } else if (sizeChoice.equals("3")) {
            size = "Large";
        }


        String flavorChoice = "";
        String flavor = "";

        boolean validFlavor = false;

        while (!validFlavor) {
            System.out.println("What flavor drink would you like?");
            System.out.println("1) Coke");
            System.out.println("2) Diet Coke");
            System.out.println("3) Sprite");
            System.out.println("4) Lemonade");
            System.out.println("5) Iced Tea");
            System.out.println("6) Water");
            System.out.print("Choose flavor: ");

            flavorChoice = scanner.nextLine().strip();

            if (flavorChoice.equals("1") || flavorChoice.equals("2") ||
                    flavorChoice.equals("3") || flavorChoice.equals("4") ||
                    flavorChoice.equals("5") || flavorChoice.equals("6")) {
                validFlavor = true;
            } else {
                System.out.println("Invalid flavor option. Please choose 1, 2, 3, 4, 5, or 6.");
            }
        }

        if (flavorChoice.equals("1")) {
            flavor = "Coke";
        } else if (flavorChoice.equals("2")) {
            flavor = "Diet Coke";
        } else if (flavorChoice.equals("3")) {
            flavor = "Sprite";
        } else if (flavorChoice.equals("4")) {
            flavor = "Lemonade";
        } else if (flavorChoice.equals("5")) {
            flavor = "Iced Tea";
        } else if (flavorChoice.equals("6")) {
            flavor = "Water";
        }

        Drink drink = new Drink(size, flavor);

        currentOrder.addDrink(drink);

        System.out.println(size + " " + flavor + " drink added to your order.");
    }
}
