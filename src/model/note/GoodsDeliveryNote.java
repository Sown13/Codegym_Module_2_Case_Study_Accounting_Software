package model.note;

//import model.product.ProductFactory;

import manager.note_manager.NoteManager;
import manager.queue.ProductQueue;
import manager.queue.ProductQueueManager;
import model.product.Product;

//Phiếu xuất kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsDeliveryNote extends Note {
    private static int specialNoteValue = 10_000;
    private Product productDelivery;

    public GoodsDeliveryNote(String productName, int quantity) {
        super(productName, quantity);
        specialNoteValue++;
        this.noteId = "DeliverNote.No" + specialNoteValue;
        for (ProductQueue productQueue : ProductQueueManager.getProductQueueList()) {
            if (productQueue.getProductQueueName().equals(productName)) {
                this.productDelivery = productQueue.getRepresentationProduct();
                this.totalAmount = productQueue.decreaseQuantity(quantity);
                break;
            }
        }
        NoteManager noteManager = new NoteManager();
        noteManager.add(this);
    }

    public Product getProductDelivery() {
        return productDelivery;
    }
}
