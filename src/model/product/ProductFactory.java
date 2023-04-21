package model.product;

public class ProductFactory {
    public Product getProduct(int choice){
       switch (choice){
           case 1 -> {
               return new ProductEXPLimited();
           }
           case 2 -> {
               return new ProductEXPUnLimited();
           }
           default -> {
               return null;
           }
       }
    }
}
