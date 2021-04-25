package com.streamliners.models;

import java.util.HashMap;
import java.util.Scanner;

public class MenuCustomer {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * To add available product in the cart
     *
     * @param cart     current cart of the items
     * @param products map of all the products available
     */
    public static void addItem(Cart cart, HashMap<String, Product> products) {
        // Checking for the available products
        if (products.isEmpty()) {
            System.out.print("\u001B[31m" + "\nSorry :( No products available" + "\u001B[0m");
            return;
        }
        while (true) {
            // Displaying menu to select product to add in the cart
            System.out.print("\nChoose from the following products..." +
                    "\n0: Go Back");

            // Index of the menu
            int i = 1;

            // Array of objects for the name of the available products
            Object[] productNames = products.keySet().toArray();

            // Displaying name of the products available in the shop for purchasing
            for (String key : products.keySet()) {
                System.out.print("\n" + (i++) + ": " + products.get(key).name);
            }

            // Taking response from the user
            System.out.print("\nPlease enter your response: ");
            int chooseOption = scanner.nextInt();

            // While user select Go Back the break the loop
            if (chooseOption == 0) break;

            // Trying to add the product in the cart by accessing the index from the menu
            // if FAILED then the user might entered wrong input as displayed in the menu
            try {
                // Index of the product in the product map
                int index = chooseOption - 1;

                // Accessing the product through the key which is accessed from it's index value
                Product product = products.get(productNames[index]);

                // Checking for the product type
                if (product.type == ProductType.TYPE_WB) {
                    // Taking quantity for the product
                    System.out.print("\nPlease enter the quantity of the product: ");
                    float qty = scanner.nextFloat();

                    // Adding the product in the cart as an item
                    cart.add(product, qty);
                } else {
                    i = 1;

                    // Displaying variants of the product
                    System.out.print("\nChoose Variant to add into cart...");
                    for (Variant variant : product.VariantList) {
                        System.out.print("\n" + (i++) + ": " + variant.name + " Rs. " + variant.price);
                    }
                    System.out.print("\nPlease enter your response: ");
                    chooseOption = scanner.nextInt();

                    // Index of the variant choose
                    index = chooseOption - 1;

                    // Accessing the variant through it's index
                    Variant variant = product.VariantList.get(index);

                    // Adding the variant based product in the cart
                    cart.add(product, variant);
                }
                System.out.println( "DONE! Product added into cart successfully." );
            } catch (Exception e) {
                System.out.print("\nERROR! wrong input ." );
            }
        }
    }

    // To remove item from the cart
    public static void removeItem(Cart cart, HashMap<String, Product> products) {
        while (true) {
            // Displaying the menu to select item to be added
            System.out.print("\nChoose from the following products..." +
                    "\n0: Go Back");

            // Menu index
            int i = 1;

            // Array of the name of the items in the cart
            Object[] itemsName = cart.cartItem.keySet().toArray();
            for (String key : cart.cartItem.keySet()) {
                System.out.print("\n" + (i++) + ": " + cart.cartItem.get(key).name);
            }

            System.out.print("\nPlease enter your response: ");
            int chooseOption = scanner.nextInt();

            // To go back from the menu
            if (chooseOption == 0) return;

            // trying to remove the product
            // otherwise FAILED then there is no product in the cart with the name entered
            try {
                // Index to access the cart item to be edited
                int index = chooseOption - 1;

                // Get the key to get the product from the product list
                String[] key = itemsName[index].toString().split(" ");
                Product product = products.get(key[0]);


                // Removing the product from the cart
                cart.remove(product);
                System.out.println("\u001B[32m" + "DONE! Product removed successfully from cart." + "\u001B[0m");
                // Return the function when item removed
                return;
            } catch (Exception e) {
                System.out.println("\u001B[31m" + "ERROR! wrong input entered." + "\u001B[0m");
            }
        }
    }

     // To edit item in the cart
    public static void editItem(Cart cart, HashMap<String, Product> products) {
        while (true) {
            // Displaying the menu to select item to be added
            System.out.print("\nChoose from the following products..." +
                    "\n0: Go Back");

            // Menu index
            int i = 1;

            // Array of the name of the items in the cart
            Object[] itemsName = cart.cartItem.keySet().toArray();
            for (String key : cart.cartItem.keySet()) {
                System.out.print("\n" + (i++) + ": " + cart.cartItem.get(key).name);
            }

            System.out.print("\nPlease enter your response: ");
            int chooseOption = scanner.nextInt();

            // To go back from the menu
            if (chooseOption == 0) return;

            // Trying to edit the item
            // otherwise FAILED then the user must enter wrong input
            try {
                // Index to access the cart item to be edited
                int index = chooseOption - 1;

                // Get the key to get the product from the product list
                String[] key = itemsName[index].toString().split(" ");
                Product product = products.get(key[0]);

                // Checking the type of the product
                if (product.type == ProductType.TYPE_WB) {
                    System.out.print("\nEnter new quantity of the product: ");
                    float qty = scanner.nextFloat();

                    // removing the product from the cart and adding new product with new quantity
                    cart.remove(product);
                    cart.add(product, qty);
                } else {
                    i = 1;

                    // Displaying menu for the variants available for the product
                    System.out.print("\nChoose new Variant...");
                    for (Variant variant : product.VariantList) {
                        System.out.print("\n" + (i++) + ": " + variant.name + " Rs. " + variant.price);
                    }
                    System.out.print("\nPlease enter your response: ");
                    chooseOption = scanner.nextInt();
                    index = chooseOption - 1;

                    // Variant of the product
                    Variant variant = product.VariantList.get(index);

                    // removing the product from the cart and adding new product with new quantity
                    cart.remove(product);
                    cart.add(product, variant);
                }
                System.out.println("\u001B[32m" + "DONE! Product edited successfully." + "\u001B[0m");
            } catch (Exception e) {
                System.out.print("\u001B[31m" + "\nERROR! wrong input entered." + "\u001B[0m");
            }
        }
    }
}

