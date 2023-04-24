package model.note;

//import model.product.ProductFactory;

import service.note_manager.NoteManager;
import service.queue.ProductQueue;
import service.queue.ProductQueueManager;
import model.product.Product;

//Phiếu xuất kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsDeliveryNote extends Note {
    private static int specialNoteValue = 10_000;
    private Product productDelivery;
    private double totalExpense;

    public GoodsDeliveryNote(String productName, int quantity,String userNameCreateNote) {
        super(productName, quantity,userNameCreateNote);
        specialNoteValue++;
        this.noteId = "DeliverNote.No" + specialNoteValue;
        for (ProductQueue productQueue : ProductQueueManager.getProductQueueList()) {
            if (productQueue.getProductQueueName().equals(productName)) {
                this.productDelivery = productQueue.getRepresentationProduct();
                this.totalAmount = productQueue.decreaseQuantity(quantity);
                this.totalExpense = productQueue.getTotalOriginalPrice();
                break;
            }
        }
        NoteManager noteManager = new NoteManager();
        noteManager.add(this);
    }

    public Product getProductDelivery() {
        return productDelivery;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    @Override
    public String toString() {
        return "GoodsDeliveryNote{" +
                "productDelivery=" + productDelivery +
                ", totalExpense=" + totalExpense +
                ", noteId='" + noteId + '\'' +
                ", userNameCreateNote='" + userNameCreateNote + '\'' +
                ", reason='" + reason + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}'+ "\n";
    }
}
