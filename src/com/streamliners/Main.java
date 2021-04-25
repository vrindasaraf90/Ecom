package com.streamliners;

import com.streamliners.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //to check who is using the application
        String a = "Are you a customer(1) OR shopkeeper(0)";

        Scanner who = new Scanner(System.in);
        int option = who.nextInt();

        if (option == 0) {
            String CustomerMenu = "Select your choice from the given ones..." +
                    "\n1: To add product " +
                    "\n2: To edit product " +
                    "\n3: To delete product ";

            // Map of all the available products
            HashMap<String, Product> products = new HashMap<>();

            // Car object to store items
            Cart cart = new Cart();

            Scanner scanner = new Scanner(System.in);

            System.out.print(CustomerMenu);


            int chooseOption = scanner.nextInt();

            switch (chooseOption) {

                case 1:
                    System.out.print("\nYou choose to add a product...");
                    MenuShopkeeper.addProduct(products);
                    break;
                case 2:
                    System.out.print("\nYou choose to edit a product...");
                    MenuShopkeeper.editProduct(products);
                    break;
                case 3:
                    System.out.print("\nYou choose to delete a product...");
                    MenuShopkeeper.deleteProduct(products);
                    break;

                default:
                    System.out.println("ERROR! You entered wrong input.");

            }
        } else {
            // Menu Driver - which displays options to the user
            String optionsMenu = "Select your choice from the given ones..." +

                    "\n\n1: To add product" +
                    "\n2: To edit product" +
                    "\n3: To remove product from cart" +
                    "\n4: To place order" +
                    "\nPlease enter your choice: ";

            // Map of all the available products
            HashMap<String, Product> products = new HashMap<>();

            // Car object to store items
            Cart cart = new Cart();

            Scanner scanner = new Scanner(System.in);

            System.out.print(optionsMenu);


            int chooseOption = scanner.nextInt();

            switch (chooseOption) {

                case 1:
                    System.out.print("\nYou choose to add a product in your cart");
                    MenuCustomer.addItem(cart, products);
                    break;
                case 2:
                    System.out.print("\nYou choose to edit a item in cart");
                    MenuCustomer.editItem(cart, products);
                    break;
                case 3:
                    System.out.print("\nYou choose to delete a item from cart");
                    MenuCustomer.removeItem(cart, products);
                    break;

                case 4:
                    System.out.println("THANK YOU!ORDER RECEIVED");
                    return;

                default:
                    System.out.println("ERROR! You entered wrong input.");
            }
            System.out.println();
        }
    }
}



          /*  Product apple = new Product("Apple", "",1F,80F);
            Product orange = new Product("Orange", "",1F,90F);
            Product kiwi = new Product("kiwi", "", new ArrayList<>(
                    Arrays.asList(
                            new Variant("500gm", 50.0f),
                            new Variant("1kg", 100.0f)
                    )));
            Product surfExcel = new Product("surfExcel", "", new ArrayList<>(
                    Arrays.asList(
                            new Variant("1kg", 100.0f))));

            Cart cart = new Cart();
        cart.add(orange,2.5F);
        cart.add(kiwi,  kiwi.VariantList.get(1));
        cart.add(kiwi,  kiwi.VariantList.get(1));
        cart.add(kiwi,  kiwi.VariantList.get(1));
        cart.add(surfExcel,  surfExcel.VariantList.get(0));
        cart.add(surfExcel,  surfExcel.VariantList.get(0));

        System.out.println(cart);

        cart.remove(orange);
        System.out.println();
        System.out.println(cart);

        cart.decrement(surfExcel, surfExcel.VariantList.get(0));
        System.out.println();
        System.out.println(cart);
        }
    } */

           