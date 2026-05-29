package com.pluralsight.ui;

import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Topping;
import com.pluralsight.model.SmallSandwich;
import com.pluralsight.model.MediumSandwich;
import com.pluralsight.model.LargeSandwich;

import java.util.Scanner;

public class AddSandwichScreen {

    Scanner scanner = new Scanner(System.in);

    public void addSandwichToOrder(Order currentOrder) {

        String size = "";
        boolean validSize = false;

        while (!validSize) {
            System.out.println("What size sandwich would you like?");
            System.out.println("4) 4 inch");
            System.out.println("8) 8 inch");
            System.out.println("12) 12 inch");
            System.out.print("Enter size: ");

            size = scanner.nextLine().strip();

            if (size.equals("4") || size.equals("8") || size.equals("12")) {
                validSize = true;
            } else {
                System.out.println("Invalid size. Please choose 4, 8, or 12.");
            }
        }

        String breadChoice = "";
        String bread = "";
        boolean validBread = false;

        while (!validBread) {
            System.out.println("What bread would you like?");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");
            System.out.print("Choose bread: ");

            breadChoice = scanner.nextLine().strip();

            if (breadChoice.equals("1") || breadChoice.equals("2") ||
                    breadChoice.equals("3") || breadChoice.equals("4")) {
                validBread = true;
            }
            else {
                System.out.println("Invalid bread option. Please choose 1, 2, 3, or 4.");
            }
        }

        if (breadChoice.equals("1")) {
            bread = "White";}
        else if (breadChoice.equals("2")) {
            bread = "Wheat";}
        else if (breadChoice.equals("3")) {
            bread = "Rye";}
        else if (breadChoice.equals("4")) {
            bread = "Wrap";
        }

        Sandwich sandwich;

        if (size.equals("4")) {
            sandwich = new SmallSandwich(bread);
        } else if (size.equals("8")) {
            sandwich = new MediumSandwich(bread);
        } else {
            sandwich = new LargeSandwich(bread);
        }

        addMeat(sandwich);
        addCheese(sandwich);
        addOtherToppings(sandwich);
        addSauces(sandwich);

        System.out.print("Would you like the sandwich toasted? yes/no: ");
        String toastedChoice = scanner.nextLine();

        if (toastedChoice.equalsIgnoreCase("yes")) {
            sandwich.setToasted(true);
        }

        currentOrder.addSandwich(sandwich);

        System.out.println("sandwich added to your order.");
    }
    public void addMeat(Sandwich sandwich) {

        boolean addingMeat = true;
        boolean selectingExtraMeat = false;

        while (addingMeat) {

            if (selectingExtraMeat) {
                System.out.println("Select extra meat:");
            } else {
                System.out.println("Select meat:");
            }

            System.out.println("1) Steak");
            System.out.println("2) Ham");
            System.out.println("3) Salami");
            System.out.println("4) Roast Beef");
            System.out.println("5) Chicken");
            System.out.println("6) Bacon");
            System.out.println("0) Done");

            if (selectingExtraMeat) {
                System.out.print("Choose extra meat: ");
            } else {
                System.out.print("Choose meat: ");
            }

            String choice = scanner.nextLine().strip();

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
                case "0":
                    return;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            double price;

            if (selectingExtraMeat) {
                price = 2.00;
                Topping meat = new Topping(meatName, "Meat", true, price);
                sandwich.addTopping(meat);
                System.out.println("Extra " + meatName + " added.");
                addingMeat = false;
            } else {
                price = 1.00;
                Topping meat = new Topping(meatName, "Meat", false, price);
                sandwich.addTopping(meat);
                System.out.println(meatName + " added.");

                System.out.print("Would you like extra meat? yes/no: ");
                String extraChoice = scanner.nextLine();

                while (!extraChoice.equalsIgnoreCase("yes") &&
                        !extraChoice.equalsIgnoreCase("no")) {

                    System.out.print("Invalid answer. Please type yes or no: ");
                    extraChoice = scanner.nextLine().strip();
                }


                if (extraChoice.equalsIgnoreCase("yes")) {
                    selectingExtraMeat = true;
                } else {
                    addingMeat = false;
                }
            }
        }
    }
    public void addCheese(Sandwich sandwich) {

        boolean addingCheese = true;
        boolean selectingExtraCheese = false;

        while (addingCheese) {

            if (selectingExtraCheese) {
                System.out.println("Select extra cheese:");
            } else {
                System.out.println("Select cheese:");
            }

            System.out.println("1) American");
            System.out.println("2) Provolone");
            System.out.println("3) Cheddar");
            System.out.println("4) Swiss");
            System.out.println("0) No cheese");

            if (selectingExtraCheese) {
                System.out.print("Choose extra cheese: ");
            } else {
                System.out.print("Choose cheese: ");
            }

            String choice = scanner.nextLine().strip();

            String cheeseName = "";

            switch (choice) {
                case "1":
                    cheeseName = "American";
                    break;
                case "2":
                    cheeseName = "Provolone";
                    break;
                case "3":
                    cheeseName = "Cheddar";
                    break;
                case "4":
                    cheeseName = "Swiss";
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            double price;

            if (selectingExtraCheese) {
                price = 1.50;

                Topping cheese = new Topping(cheeseName, "Cheese", true, price);
                sandwich.addTopping(cheese);

                System.out.println("Extra " + cheeseName + " added.");

                addingCheese = false;

            } else {
                price = 0.75;

                Topping cheese = new Topping(cheeseName, "Cheese", false, price);
                sandwich.addTopping(cheese);

                System.out.println(cheeseName + " added.");

                System.out.print("Would you like extra cheese? yes/no: ");
                String extraChoice = scanner.nextLine().strip();

                while (!extraChoice.equalsIgnoreCase("yes") &&
                        !extraChoice.equalsIgnoreCase("no")) {

                    System.out.print("Invalid answer. Please type yes or no: ");
                    extraChoice = scanner.nextLine().strip();
                }

                if (extraChoice.equalsIgnoreCase("yes")) {
                    selectingExtraCheese = true;
                } else {
                    addingCheese = false;
                }
            }
        }
    }
    public void addOtherToppings(Sandwich sandwich) {

        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("Select other toppings:");
            System.out.println("1) Lettuce");
            System.out.println("2) Peppers");
            System.out.println("3) Onions");
            System.out.println("4) Tomatoes");
            System.out.println("5) Jalapeños");
            System.out.println("6) Cucumbers");
            System.out.println("7) Pickles");
            System.out.println("8) Guacamole");
            System.out.println("9) Mushrooms");
            System.out.println("10) No more toppings");
            System.out.print("Choose topping: ");

            String choice = scanner.nextLine();

            String toppingName = "";

            switch (choice) {
                case "1":
                    toppingName = "Lettuce";
                    break;
                case "2":
                    toppingName = "Peppers";
                    break;
                case "3":
                    toppingName = "Onions";
                    break;
                case "4":
                    toppingName = "Tomatoes";
                    break;
                case "5":
                    toppingName = "Jalapeños";
                    break;
                case "6":
                    toppingName = "Cucumbers";
                    break;
                case "7":
                    toppingName = "Pickles";
                    break;
                case "8":
                    toppingName = "Guacamole";
                    break;
                case "9":
                    toppingName = "Mushrooms";
                    break;
                case "10":
                    addingToppings = false;
                    continue;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            System.out.print("Would you like extra " + toppingName + "? yes/no: ");
            String extraChoice = scanner.nextLine();

            boolean extra = extraChoice.equalsIgnoreCase("yes");

            double price = 0.00;

            Topping topping = new Topping(toppingName, "Other", extra, price);
            sandwich.addTopping(topping);

            if (extra) {
                System.out.println("Extra " + toppingName + " added.");
            } else {
                System.out.println(toppingName + " added.");
            }

            System.out.print("Would you like to add another topping? yes/no: ");
            String anotherTopping = scanner.nextLine().strip();

            while (!anotherTopping.equalsIgnoreCase("yes") &&
                    !anotherTopping.equalsIgnoreCase("no")) {

                System.out.print("Invalid answer. Please type yes or no: ");
                anotherTopping = scanner.nextLine().strip();
            }


            if (anotherTopping.equalsIgnoreCase("no")) {
                addingToppings = false;
            }
        }
    }
    public void addSauces(Sandwich sandwich) {

        boolean addingSauce = true;

        while (addingSauce) {
            System.out.println("Select sauce:");
            System.out.println("1) Mayo");
            System.out.println("2) Mustard");
            System.out.println("3) Ketchup");
            System.out.println("4) Ranch");
            System.out.println("5) Thousand Islands");
            System.out.println("6) Vinaigrette");
            System.out.println("7) No sauce");
            System.out.print("Choose sauce: ");

            String choice = scanner.nextLine();

            String sauceName = "";

            switch (choice) {
                case "1":
                    sauceName = "Mayo";
                    break;

                case "2":
                    sauceName = "Mustard";
                    break;

                case "3":
                    sauceName = "Ketchup";
                    break;

                case "4":
                    sauceName = "Ranch";
                    break;

                case "5":
                    sauceName = "Thousand Islands";
                    break;

                case "6":
                    sauceName = "Vinaigrette";
                    break;

                case "7":
                    addingSauce = false;
                    continue;

                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            Topping sauce = new Topping(sauceName, "Sauce", false, 0.00);
            sandwich.addTopping(sauce);

            System.out.println(sauceName + " added.");

            System.out.print("Would you like to add another sauce? yes/no: ");
            String anotherSauce = scanner.nextLine();

            if (anotherSauce.equalsIgnoreCase("no")) {
                addingSauce = false;
            }
        }
    }

}
