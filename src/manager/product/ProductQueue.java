package manager.product;

import model.product.Product;

import java.util.PriorityQueue;

public class ProductQueue {
    private String productQueueName;
    private int quantity = 0;
    private ProductStorageStatus storageStatus = ProductStorageStatus.OUT_OF_STOCK;
    private PriorityQueue<Product> productQueue = new PriorityQueue<>();


    public ProductQueue(int quantity, Product product) {
        if (quantity > 0) {
            this.quantity = quantity;
            increaseQuantity(quantity, product);
            this.productQueueName = product.getProductName();
        } else if (quantity <= 0) {
            this.productQueueName = product.getProductName();
        }
        updateStorageStatus();
    }

    public void increaseQuantity(int quantity, Product product) {
        for (int i = 0; i < quantity; i++) {
            productQueue.add(product);
        }
        updateStorageStatus();
    }

    public void decreaseQuantity(int quantity) {
        for (int i = 0; i < quantity; i++) {
            productQueue.poll();
        }
        updateStorageStatus();
    }

    public String getProductQueueName() {
        return productQueueName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PriorityQueue<Product> getProductQueue() {
        return productQueue;
    }

    public void setProductQueue(PriorityQueue<Product> productQueue) {
        this.productQueue = productQueue;
    }

    public ProductStorageStatus getStorageStatus() {
        return storageStatus;
    }

    public void updateStorageStatus() {
        if (productQueue.isEmpty()) {
            this.storageStatus = ProductStorageStatus.OUT_OF_STOCK;
        } else {
            this.storageStatus = ProductStorageStatus.AVAILABLE;
        }
        this.quantity = productQueue.size();
    }
}
