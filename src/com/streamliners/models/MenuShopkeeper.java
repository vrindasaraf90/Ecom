package com.streamliners.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class MenuShopkeeper {
    private final static Scanner scanner = new Scanner(System.in);


    //to add product to cart
    public static void addProduct(HashMap<String, Product> products) {
        // Displaying the available type of the product
        String menu = "\nSelect type of the product" +
                "\n1: Add WeightBasedProduct" +
                "\n2: Add VariantBasedProduct" +
                "\nEnter your preference: ";

        int option = 1;

        //to add WBP
        if (option == 1) addWBP(products);

            // To add VBP
        else if (option == 2) addVBP(products);

            // if user enter any other option
        else
            System.out.println("Incorrect Option.");
    }

    //to add WBP
    private static void addWBP(HashMap<String, Product> products) {
        //name of the product
        System.out.print("\nEnter name of the product: ");

        //check if input is valid
        String name = scanner.nextLine();
        while (name.isEmpty()) name = scanner.nextLine();

        String key = name.toUpperCase();

        //to Check if the product already exists
        if (products.containsKey(key)) {
            System.out.println("ERROR! Product already exists.");
            return;
        }

        //Other details related to product
        System.out.print("Enter imageURL: ");
        String imageURL = scanner.nextLine();

        System.out.print("Enter minimum quantity: ");
        float minQty = scanner.nextFloat();

        System.out.print("Enter price per kg: ");
        float pricePerKg = scanner.nextFloat();

        products.put(key, new Product(key, imageURL, minQty, pricePerKg));
        System.out.println("DONE! Product added.");
    }

    //to add VBP
    private static void addVBP(HashMap<String, Product> products) {
        // Take name of the product
        System.out.print("\nEnter name of the product: ");

        String name = scanner.nextLine();
        while (name.isEmpty()) name = scanner.nextLine();

        String key = name.toUpperCase();

        //to Check if the product already exists
        if (products.containsKey(key)) {
            System.out.println("ERROR! Product already exists.");
            return;
        }

        //Other details related to product
        System.out.print("Enter image URL of the product: ");
        String imageURL = scanner.nextLine();

        System.out.print("Enter the variant string of the product: ");
        String variantString = scanner.nextLine();

        // Separate the words enter for the variants
        String[] s = variantString.split(" ");

        // List of the variants added
        List<Variant> variants = new ArrayList<>();

        // Adding variants to the product
        for (int x = 0; x < s.length; x += 2) {
            Variant variant = new Variant(s[x], Float.parseFloat(s[x + 1]));
            variants.add(variant);
        }

        // Adding the product in the products map
        products.put(key, new Product(key, imageURL, variants));
        System.out.println("DONE! Product added successfully");

    }

    //to edit a product
    public static void editProduct(HashMap<String, Product> products) {

        // Index of the menu
        int i = 1;

        // Array of objects for the name of the available products
        Object[] productNames = products.keySet().toArray();

        // Displaying name of the products available
        for (String key : products.keySet()) {
            System.out.print("\n" + (i++) + ": " + products.get(key).name);
        }

        // Taking response from the user
        System.out.print("\nPlease enter your response: ");
        int chooseOption = scanner.nextInt();

        // Index of the product
        int index = chooseOption - 1;

        // Accessing the product through the key which is accessed from it's index value
        Product product = products.get(productNames[index]);

        // Checking the product type
        if (product.type == ProductType.TYPE_WB) {
            editWBP(product);
        } else if (product.type == ProductType.TYPE_VB) {
            editVBP(product);
        }
    }

    //to edit WBP
    private static void editWBP(Product product) {

        // Taking all the field new
        System.out.print("Enter new image URL of the product: ");
        String newImageURL = scanner.nextLine();
        while (newImageURL.isEmpty()) newImageURL = scanner.nextLine();

        System.out.print("Enter new minimum quantity of the product: ");
        float newMinQty = scanner.nextFloat();

        System.out.print("Enter new price per kg: ");
        float newPricePerKg = scanner.nextFloat();

        // Updating the product
        product.imageURL = newImageURL;
        product.minQty = newMinQty;
        product.pricePerKg = newPricePerKg;

        System.out.println("DONE! Product edit successfully.");
    }

    //to edit VBP
    private static void editVBP(Product product) {
        // Taking all the field new
        System.out.print("Enter new image URL of the product: ");
        String newImageURL = scanner.nextLine();
        while (newImageURL.isEmpty()) newImageURL = scanner.nextLine();

        System.out.print("Enter the variant string of the product: ");
        String variantString = scanner.nextLine();

        // Separate the words enter for the variants
        String[] s = variantString.split(" ");

        // List of the variants added
        List<Variant> variants = new ArrayList<>();

        // Adding variants to the product
        for (int x = 0; x < s.length; x += 2) {
            Variant variant = new Variant(s[x], Float.parseFloat(s[x + 1]));
            variants.add(variant);
        }

        // Updating the product
        product.imageURL = newImageURL;
        product.VariantList = variants;

        System.out.println("DONE! Product edit successfully.");
    }

    //to delete a product
    public static void deleteProduct(HashMap<String, Product> products) {
        while (true) {

            // Index of the menu
            int i = 1;

            // Array of objects of the available products
            Object[] productNames = products.keySet().toArray();

            // Displaying available products
            for (String key : products.keySet()) {
                System.out.print("\n" + (i++) + ": " + products.get(key).name);
            }

            // Taking response from the user
            System.out.print("\nPlease enter your response: ");
            int chooseOption = scanner.nextInt();

            // While user select Go Back the break the loop
            if (chooseOption == 0) break;

            // Index of the product in the product
            int index = chooseOption - 1;

            // Accessing the product through the key which is accessed from it's index value
            products.remove(productNames[index]);
            System.out.println("DONE! Product deleted.");
        }
    }
}
