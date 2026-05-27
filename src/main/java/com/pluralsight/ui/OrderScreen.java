package com.pluralsight.ui;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Topping;

import java.util.Scanner;

public class OrderScreen {
    Scanner scanner = new Scanner(System.in);
    public void displayOrderScreen(Order currentOrder) {

        boolean ordering = true;

        while (ordering) {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel order");
            System.out.println("Please choose an option");

            String choice = scanner.nextLine().strip();

            switch (choice){
                case "1":
                    System.out.println("Adding Sandwiches");
                    addSandwichToOrder(currentOrder);
                    break;
                case "2":
                    System.out.println("Adding Drinks");
                    addDrinkToOrder(currentOrder);
                    break;
                case "3":
                    System.out.println("Adding Chips");

                    addChipsToOrder(currentOrder);
                    break;
                case "4":
                    System.out.println("Checking out");
                    ordering = false;
                    break;
                case "0" :
                    System.out.println("Order cancelled");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;

            }


        }
    }
    public void addChipsToOrder(Order currnetOrder){

        System.out.println("What type of chips would you like?");

        String chipsChoice = scanner.nextLine();

        Chips chips = new Chips(chipsChoice);

        currnetOrder.addChip(chips);

        System.out.println(chipsChoice + " Chips added to your order");
    }

    public void addDrinkToOrder(Order currentOrder) {

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

        boolean choosingMeat = true;

        while (choosingMeat) {
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

            switch (choice) {
                case "1":
                    sandwich.addTopping(new Topping("Steak", "Meat", false, 1.00));
                    System.out.println("Steak added.");
                    break;
                case "2":
                    sandwich.addTopping(new Topping("Ham", "Meat", false, 1.00));
                    System.out.println("Ham added.");
                    break;
                case "3":
                    sandwich.addTopping(new Topping("Salami", "Meat", false, 1.00));
                    System.out.println("Salami added.");
                    break;
                case "4":
                    sandwich.addTopping(new Topping("Roast Beef", "Meat", false, 1.00));
                    System.out.println("Roast Beef added.");
                    break;
                case "5":
                    sandwich.addTopping(new Topping("Chicken", "Meat", false, 1.00));
                    System.out.println("Chicken added.");
                    break;
                case "6":
                    sandwich.addTopping(new Topping("Bacon", "Meat", false, 1.00));
                    System.out.println("Bacon added.");
                    break;
                case "0":
                    choosingMeat = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

}
