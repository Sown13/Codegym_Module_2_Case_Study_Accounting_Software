package model.bill;

//import model.product.ProductFactory;

import manager.product.ProductQueue;
import manager.product.ProductQueueManager;
import model.product.Product;

//Phiếu xuất kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsDeliveryNote extends Note{
    private static int specialNoteValue = 10_000;
    protected Product productDelivery;
    public GoodsDeliveryNote(String productName, int quantity) {
        super(productName, quantity);
        specialNoteValue++;
        this.noteId = "DeliverNote.No" + specialNoteValue;
        for(ProductQueue productQueue : ProductQueueManager.getProductQueueList()){
            if(productQueue.getProductQueueName().equals(productName)){
                this.productDelivery = productQueue.getRepresentationProduct();
                this.price = productDelivery.getProductSellPrice();
                productQueue.decreaseQuantity(quantity);
                break;
            }
        }
    }

}
