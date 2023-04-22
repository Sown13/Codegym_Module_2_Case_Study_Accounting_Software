package model.product;

import java.util.Scanner;

public class ProductFactory {
    static Scanner scanner = new Scanner(System.in);
    public Product makeProduct(String choice){
        System.out.println("Please enter the product name: ");
        String name = scanner.nextLine();
       switch (choice){
           case "limited" -> {
               return new ProductEXPLimited(name);
           }
           case "unlimited" -> {
               return new ProductEXPUnLimited(name);
           }
           default -> {
               System.out.println("Wrong choice");
               return null;
           }
       }
    }
}
