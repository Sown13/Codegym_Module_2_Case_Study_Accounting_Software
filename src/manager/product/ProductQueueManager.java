package manager.product;

import manager.IGeneralManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductQueueManager implements IGeneralManager<ProductQueue> {
    List<ProductQueue> productQueueList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add(ProductQueue productQueue) {
        productQueueList.add(productQueue);
    }

    public boolean isProductExisted(String productName){
        return productQueueList.stream().anyMatch(productQueue -> productQueue.getProductQueueName().equals(productName));
    }
    @Override
    public void remove() {
        System.out.println("Remove product by name - Please Enter the Product name:");
        String productName = scanner.nextLine();
        if (isProductExisted(productName)) {
            System.out.println("Are you sure to remove this product?" + "id: " + productName);
            System.out.println("""
                    1/ Yes, remove it!
                    0/ No, Cancel it!
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> productQueueList = productQueueList
                        .stream()
                        .filter(productQueue -> !productQueue.getProductQueueName().equals(productName))
                        .toList();
                case 0 -> System.out.println("Ok! Canceled");
            }
        } else {
            System.out.println("Product not found!");
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {

    }
}
