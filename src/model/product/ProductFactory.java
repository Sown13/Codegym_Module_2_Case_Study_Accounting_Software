package model.product;

import java.io.Serializable;
import java.util.Scanner;

public class ProductFactory implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

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
