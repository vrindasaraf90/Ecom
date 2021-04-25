package com.streamliners.models;

import java.util.HashMap;
import java.util.Scanner;

public class MenuCustomer {
    private static final Scanner scanner = new Scanner(System.in);


     //To add available product
    public static void addItem(Cart cart, HashMap<String, Product> products) {

            // Index of the menu
            int i = 1;

            // Array available products
            Object[] productNames = products.keySet().toArray();

            //  name of the products available
            for (String key : products.keySet()) {
                System.out.print("\n" + (i++) + ": " + products.get(key).name);
            }

            // Taking response from the user
            System.out.print("\nPlease enter your response: ");
            int chooseOption = scanner.nextInt();

        }

    // To remove item
    public static void removeItem(Cart cart, HashMap<String, Product> products) {

            // Menu index
            int i = 1;

            // Array of the items in the cart
            Object[] itemsName = cart.cartItem.keySet().toArray();
            for (String key : cart.cartItem.keySet()) {
                System.out.print("\n" + (i++) + ": " + cart.cartItem.get(key).name);
            }

            System.out.print("\nPlease enter your response: ");
            int chooseOption = scanner.nextInt();

            // To go back from the menu
            if (chooseOption == 0) return;

            // trying to remove the product

            try {

                int index = chooseOption - 1;

                String[] key = itemsName[index].toString().split(" ");
                Product product = products.get(key[0]);

                // Removing the product
                cart.remove(product);
                System.out.println( "DONE! Product removed successfully from cart.");

                return;
            } catch (Exception e) {
                System.out.println( "wrong input .");
            }
        }

     // To edit item
    public static void editItem(Cart cart, HashMap<String, Product> products) {
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
                System.out.println( "DONE! Product edited successfully.");
            } catch (Exception e) {
                System.out.print("\nERROR! wrong input entered." );
            }
        }
    }


