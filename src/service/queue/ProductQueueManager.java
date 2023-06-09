package service.queue;

import io.ReadData;
import io.WriteData;
import model.product.ProductEXPLimited;
import model.product.ProductEXPUnLimited;
import model.sout.NotifyForm;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductQueueManager implements IProductQueueManager {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    private static List<ProductQueue> productQueueList = new ArrayList<>();
    static ReadData<ProductQueue> loader = new ReadData<>();
    WriteData<ProductQueue> saver = new WriteData<>();

    public static void loadProduct(){
        String path = "src/io/database/product_queue_save.txt";
        List<ProductQueue> loadedList = loader.loadListData(path);
        productQueueList.addAll(loadedList);
        System.out.println("Product List imported!");
    }
    private void saveProduct(){
        String path = "src/io/database/product_queue_save.txt";
        saver.writeToSaveFile(productQueueList,path);
    }

    public ProductQueueManager() {
    }

    @Override
    public void add(ProductQueue productQueue) {
        if (productQueueList.isEmpty()) {
            productQueueList.add(productQueue);
        } else {
            if (isProductExisted(productQueue.getProductQueueName())) {
                for (ProductQueue queue : productQueueList) {
                    if (productQueue.getProductQueueName().equals(queue.getProductQueueName())) {
                        queue.increaseQuantity(productQueue.getQuantity(), productQueue.getRepresentationProduct());
                    }
                }
            } else {
                productQueueList.add(productQueue);
            }
        }
        saveProduct();
    }

    public boolean isProductExisted(String productName) {
        return productQueueList.stream().anyMatch(productQueue -> productQueue.getProductQueueName().equals(productName));
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Remove product by name - Please Enter the Product name:");
        String productName = scanner.nextLine();
        if (isProductExisted(productName)) {
            System.out.println("Are you sure to remove this product?" + "name: " + productName);
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
        saveProduct();
    }


    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit product by name - Please enter the product name: ");
        String productName = scanner.nextLine();
        if (isProductExisted(productName)) {
            ProductQueue productQueueToEdit = productQueueList
                    .stream()
                    .filter(productQueue -> productQueue.getProductQueueName().equals(productName))
                    .findFirst()
                    .get();
            System.out.println("Are you sure to edit this product?" + "name: " + productQueueToEdit);
            System.out.println("""
                    1/ Yes, let's edit it!
                    0/ No, Cancel it!
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                NotifyForm.textNoteEditByName();
                String name = scanner.nextLine();
                String description = scanner.nextLine();
                double sellPrice = Double.parseDouble(scanner.nextLine());
                productQueueToEdit.setProductName(name);
                productQueueToEdit.setProductDetail(description);
                productQueueToEdit.setSellPrice(sellPrice);
            } else {
                System.out.println("Canceled!");
            }
        } else {
            System.out.println("Product not found!");
        }
        saveProduct();
    }

    @Override
    public void display() {
        int order = 0;
        for (ProductQueue representationProduct : productQueueList) {
            System.out.println(++order + "-"
                    + representationProduct.getRepresentationProduct()
                    + "quantity: " + representationProduct.getQuantity() + " - "
                    + representationProduct.getStorageStatus());
        }
    }

    public static List<ProductQueue> getProductQueueList() {
        return productQueueList;
    }
    @Override
    public void searchProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key word");
        String keyword = scanner.nextLine();
        List<ProductQueue> searchResult = productQueueList
                .stream()
                .filter(productQueue -> productQueue.getProductQueueName().contains(keyword) ||
                        productQueue.getRepresentationProduct().getProductId().contains(keyword) ||
                        productQueue.getRepresentationProduct().getProductDetail().contains(keyword))
                .toList();
        System.out.println(searchResult);
    }

    public double getTotalCurrentOriginalPrice(){
        double totalCurrentOriginalPrice = 0;
        for(ProductQueue productQueue : productQueueList){
            totalCurrentOriginalPrice += productQueue.getTotalOriginalPrice();
        }
        return totalCurrentOriginalPrice;
    }
    public List<ProductQueue> getEXPUnlimitedList(){
        return productQueueList
                .stream()
                .filter(productQueue -> productQueue.getRepresentationProduct() instanceof ProductEXPUnLimited)
                .toList();
    }
    public List<ProductQueue> getExpLimitedList(){
        return productQueueList
                .stream()
                .filter(productQueue -> productQueue.getRepresentationProduct() instanceof ProductEXPLimited)
                .toList();
    }

    public void sortByName(){
        productQueueList.sort(Comparator.comparing(ProductQueue::getProductQueueName));
        display();
    }
    public void clearProductData(){
        productQueueList.clear();
        saveProduct();
    }
}
