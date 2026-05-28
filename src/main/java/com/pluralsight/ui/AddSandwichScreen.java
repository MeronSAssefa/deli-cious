package com.pluralsight.ui;

import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Topping;

import java.util.Scanner;

public class AddSandwichScreen {

    Scanner scanner = new Scanner(System.in);

    public void addSandwichToOrder(Order currentOrder) {

        System.out.println("What size sandwich would you like?");
        System.out.println("4) 4 inch");
        System.out.println("8) 8 inch");
        System.out.println("12) 12 inch");
        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        System.out.println("What bread would you like?");
        System.out.println("White");
        System.out.println("Wheat");
        System.out.println("Rye");
        System.out.println("Wrap");
        System.out.print("Enter bread: ");
        String bread = scanner.nextLine();

        Sandwich sandwich = new Sandwich(size, bread);

        addMeat(sandwich);
        //addCheese(sandwich);
        //addOtherToppings(sandwich);
        //addSauces(sandwich);

        System.out.print("Would you like the sandwich toasted? yes/no: ");
        String toastedChoice = scanner.nextLine();

        if (toastedChoice.equalsIgnoreCase("yes")) {
            sandwich.setToasted(true);
        }

        currentOrder.addSandwich(sandwich);

        System.out.println(size + " inch " + bread + " sandwich added to your order.");
    }
    public void addMeat(Sandwich sandwich) {

        boolean addingMeat = true;

        while (addingMeat) {
            System.out.println("Select meat:");
            System.out.println("1) Steak");
            System.out.println("2) Ham");
            System.out.println("3) Salami");
            System.out.println("4) Roast Beef");
            System.out.println("5) Chicken");
            System.out.println("6) Bacon");
            System.out.println("0) Done");
            System.out.print("Choose meat: ");

            String choice = scanner.nextLine().strip().toUpperCase();

            String meatName = "";

            switch (choice) {
                case "1":
                    meatName = "Steak";
                    break;
                case "2":
                    meatName = "Ham";
                    break;
                case "3":
                    meatName = "Salami";
                    break;
                case "4":
                    meatName = "Roast Beef";
                    break;
                case "5":
                    meatName = "Chicken";
                    break;
                case "6":
                    meatName = "Bacon";
                    break;
                case "7":
                    addingMeat = false;
                    continue;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            System.out.print("Would you like extra " + meatName + "? yes/no: ");
            String extraChoice = scanner.nextLine();

            boolean extra = extraChoice.equalsIgnoreCase("yes");

            double price;

            if (extra) {
                price = 2.00;
            } else {
                price = 1.00;
            }

            Topping meat = new Topping(meatName, "Meat", extra, price);
            sandwich.addTopping(meat);

            if (extra) {
                System.out.println("Extra " + meatName + " added.");
            } else {
                System.out.println(meatName + " added.");
            }

            System.out.print("Would you like to add another meat? yes/no: ");
            String anotherMeat = scanner.nextLine();

            if (anotherMeat.equalsIgnoreCase("no")) {
                addingMeat = false;
            }
        }
    }

}
