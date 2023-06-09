package model.product;

import java.io.Serial;
import java.io.Serializable;


public class ProductFactory implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    public Product makeProduct(String choice, String name){
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
