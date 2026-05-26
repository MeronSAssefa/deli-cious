package com.pluralsight.ui;


import com.pluralsight.model.Order;

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

       String choice = scanner.nextLine().strip();


           switch (choice) {

               case "1":
                   System.out.println("Starting a new order");
                   // creating a new order object
                   Order currentOrder = new Order();

                   OrderScreen orderScreen = new OrderScreen();
                   orderScreen.displayOrderScreen(currentOrder);
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



}
