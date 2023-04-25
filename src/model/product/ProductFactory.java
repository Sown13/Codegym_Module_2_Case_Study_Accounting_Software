package model.product;

import java.util.Scanner;

public class ProductFactory {

    public Product makeProduct(String choice, String name){
        Scanner scanner = new Scanner(System.in);
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
