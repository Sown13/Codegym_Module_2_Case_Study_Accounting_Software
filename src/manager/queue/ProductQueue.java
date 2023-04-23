package manager.queue;

import model.product.Product;

import java.util.LinkedList;


public class ProductQueue {
    private final Product representationProduct;
    private final String productQueueName;
    private int quantity = 0;
    private ProductStorageStatus storageStatus = ProductStorageStatus.OUT_OF_STOCK;
    private final LinkedList<Product> productQueue = new LinkedList<>();


    public ProductQueue(int quantity, Product product) {
        this.representationProduct = product;
        if (quantity > 0) {
            this.quantity = quantity;
            increaseQuantity(quantity, product);
        }
        this.productQueueName = product.getProductName();
        updateStorageStatus();
    }

    public double increaseQuantity(int quantity, Product product) {
        double totalOriginalPrice = product.getProductOriginalPrice() * quantity;
        for (int i = 0; i < quantity; i++) {
            productQueue.addFirst(product);
        }
        updateStorageStatus();
        return totalOriginalPrice;
    }

    public double decreaseQuantity(int quantity) {
        double totalSellPrice = 0;
        if (quantity > productQueue.size()) {
            System.out.println("Not enough quantity");
            return totalSellPrice;
        } else {
            for (int i = 0; i < quantity; i++) {
                Product tempProduct = productQueue.poll();
                totalSellPrice += tempProduct.getProductSellPrice();
            }
            updateStorageStatus();
        }
        return totalSellPrice;
    }

    public String getProductQueueName() {
        return productQueueName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setSellPrice(double sellPrice) {
        for (Product product : productQueue) {
            product.setProductSellPrice(sellPrice);
        }
        this.representationProduct.setProductSellPrice(sellPrice);
    }

    public void setProductName(String name) {
        for (Product product : productQueue) {
            product.setProductName(name);
        }
        this.representationProduct.setProductName(name);
    }

    public void setProductDetail(String detail) {
        for (Product product : productQueue) {
            product.setProductDetail(detail);
        }
        this.representationProduct.setProductDetail(detail);
    }

    public ProductStorageStatus getStorageStatus() {
        return storageStatus;
    }

    public Product getRepresentationProduct() {
        return representationProduct;
    }

    public void updateStorageStatus() {
        if (productQueue.isEmpty()) {
            this.storageStatus = ProductStorageStatus.OUT_OF_STOCK;
        } else {
            this.storageStatus = ProductStorageStatus.AVAILABLE;
        }
        this.quantity = productQueue.size();
    }

    public double getTotalOriginalPrice(){
        double totalOriginalPrice = 0;
        for (Product product : productQueue){
            totalOriginalPrice += product.getProductOriginalPrice();
        }
        return totalOriginalPrice;
    }

    @Override
    public String toString() {
        return representationProduct
                + "Quantity: " + this.getQuantity()
                + "\n";
    }
}
