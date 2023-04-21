package manager.product;

import model.product.Product;
import model.product.ProductEXPLimited;

import java.util.*;

public class ProductManager implements IProductManager {
    public List<Product> productList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductManager() {
    }

    public boolean isProductExisted(String key) {
        return productList
                .stream()
                .anyMatch(product -> product.getProductId().equals(key));
    }

    public void updateQuantity(Product product){
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void remove() {
        System.out.println("Remove product by ID - Please Enter the Product ID:");
        String productID = scanner.nextLine();
        if (isProductExisted(productID)) {
            System.out.println("Are you sure to remove this product?" + "id: " + productID);
            System.out.println("""
                    1/ Yes, remove it!
                    0/ No, Cancel it!
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> productList = productList
                        .stream()
                        .filter(product -> product.getProductId().equals(productID))
                        .toList();
                case 0 -> System.out.println("Ok! Canceled");
            }
        } else {
            System.out.println("ID not found!");
        }
    }

    public Product findProductByName(String productKeyName) {
            List<Product> tempProductList = productList
                    .stream()
                    .filter(product -> product.getProductName().equals(productKeyName))
                    .toList();
            return tempProductList.get(0);
    }

    @Override
    public void edit() {
        Product productToEdit;
        System.out.println("Edit product by ID - Please Enter the Product ID: ");
        String productId = scanner.nextLine();
        if (isProductExisted(productId)) {
            productToEdit = findProductByName(productId);
            System.out.println("You are trying to edit this product" + productToEdit);
            System.out.println("Enter the new name");
            String name = scanner.nextLine();
            System.out.println("Enter the new Sell Price");
            double sellPrice = Double.parseDouble(scanner.nextLine());
            if (productToEdit instanceof ProductEXPLimited){
                System.out.println("Enter the ");
            }
        }
        else {
            System.out.println("ID not found!");
        }
    }

    @Override
    public void sortProductByPrice() {

    }

    @Override
    public void display() {
        System.out.println("List of the Products");
        System.out.println(productList);
    }
}
