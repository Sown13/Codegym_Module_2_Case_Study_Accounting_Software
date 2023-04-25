package model.note;

//import model.product.ProductFactory;

import service.note_manager.NoteManager;
import service.queue.ProductQueue;
import service.queue.ProductQueueManager;
import model.product.Product;

import java.io.Serial;

//Phiếu xuất kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsDeliveryNote extends Note {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    public static int specialNoteValue = 10_000;
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
                setTotalExpense(productQueue.getTotalOriginalPrice());
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

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    @Override
    public String toString() {
        return "GoodsDeliveryNote{" +
                "productDelivery=" + productDelivery +
                ", totalExpense=" + totalExpense +
                ", noteId='" + super.noteId + '\'' +
                ", userNameCreateNote='" + super.userNameCreateNote + '\'' +
                ", reason='" + super.reason + '\'' +
                ", productName='" + super.productName + '\'' +
                ", quantity=" + super.quantity +
                ", totalAmount=" + super.totalAmount +
                '}'+ "\n";
    }
}
