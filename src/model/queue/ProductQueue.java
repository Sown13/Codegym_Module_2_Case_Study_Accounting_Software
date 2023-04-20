package model.queue;

import model.product.Product;

public class ProductQueue extends LinkedListQueue<Product> {
    public void receiveGoods(Product product) {
        for(int i =0; i< product.getProductQuantity();i++) {
            super.enQueue(product);
        }
    }
    public void deliveryGoods(Product product, int quantity){
        for (int i =0; i < quantity; i++){
            super.deQueue();
            product.setProductQuantity(product.getProductQuantity()-1);
        }
    }
}
