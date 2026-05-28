package com.pluralsight.ui;
import com.pluralsight.model.Order;
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

            switch (choice) {
                case "1":
                    System.out.println("Adding Sandwiches");
                    AddSandwichScreen addSandwichScreen = new AddSandwichScreen();

                    addSandwichScreen.addSandwichToOrder(currentOrder);
                    break;
                case "2":
                    System.out.println("Adding Drinks");
                    AddDrinkScreen addDrinkScreen = new AddDrinkScreen();

                    addDrinkScreen.addDrinkToOrder(currentOrder);
                    break;
                case "3":
                    System.out.println("Adding Chips");
                    AddChipsScreen addChipsScreen = new AddChipsScreen();

                    addChipsScreen.addChipsToOrder(currentOrder);
                    break;
                case "4":
                    CheckoutScreen checkoutScreen = new CheckoutScreen();
                    checkoutScreen.displayCheckoutScreen(currentOrder);
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order cancelled");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;

            }
        }
    }

}
