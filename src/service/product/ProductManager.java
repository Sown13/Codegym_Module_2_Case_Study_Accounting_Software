package service.product;

import model.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements IProductManager {
    public List<Product> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductManager() {
    }
    public boolean isProductExisted(String key){
        return list
                .stream()
                .anyMatch(product -> product.getProductId().equals(key));
    }


    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public void remove() {
        System.out.println("Remove product by ID - Please Enter the Product ID:");
        String productID = scanner.nextLine();
        if(isProductExisted(productID)){
            for(int i = 0; i < list.size(); i++){
                if(productID.equals(list.get(i).getProductId())){
                    list.remove(i);
                    break;
                }
            }
        }
        else System.out.println("ID not found!");
    }

    @Override
    public void edit() {

    }

    @Override
    public void sortProductByPrice() {

    }

    @Override
    public void display() {
        System.out.println("List of the Products");
        System.out.println(list);
    }
}
