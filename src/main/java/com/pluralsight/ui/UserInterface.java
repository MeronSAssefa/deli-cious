package com.pluralsight.ui;

import java.util.Scanner;

public class UserInterface {
   Scanner scanner = new Scanner(System.in);

   public void displayHomeScreen(){

       boolean running = true;

       while (running) {
       System.out.println("=======================");
       System.out.println("=======================");
       System.out.println(" Welcome to DELI-CIOUS ");
       System.out.println("=======================");
       System.out.println("=======================");
       System.out.println("1) New Order");
       System.out.println("0) Exit");
       System.out.println("Please choose an option");

       String choice = scanner.nextLine();


           switch (choice) {

               case "1":
                   System.out.println("Starting a new order");
                   displayOrderScreen();
                   break;
               case "0":
                   System.out.println("You have Exited");
                   running = false;
                   break;
               default:
                   System.out.println("Invalid Option");
                   break;

           }

           System.out.println("---------------------------");
       }
    }

    public void displayOrderScreen() {

        boolean ordering = true;

        while (ordering) {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel order");
            System.out.println("Please choose an option");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    System.out.println("Adding Sandwiches");
                    break;
                case "2":
                    System.out.println("Adding Drinks");
                    break;
                case "3":
                    System.out.println("Adding Chips");
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
}
