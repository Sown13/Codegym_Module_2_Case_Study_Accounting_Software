package model.note;

//import model.product.ProductFactory;

import model.product.Product;
import service.note_manager.NoteManager;
import service.queue.ProductQueue;
import service.queue.ProductQueueManager;

import java.io.Serial;

//Phiếu xuất kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsDeliveryNote extends Note {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    public static int specialNoteValue = 10_000;
    private Product productDelivery;
    private double totalExpense = 0;

    public GoodsDeliveryNote(String productName, int quantity, String userNameCreateNote) {
        super(productName, quantity, userNameCreateNote);
        specialNoteValue++;
        NoteManager noteManager = new NoteManager();
        if (isProductExisted(productName)) {
            for (ProductQueue productQueue : ProductQueueManager.getProductQueueList()) {
                if (productQueue.getProductQueueName().equals(productName)) {
                    this.productDelivery = productQueue.getRepresentationProduct();
                    this.totalAmount = productQueue.decreaseQuantity(quantity);
                    setTotalExpense(productQueue.getTotalOriginalPrice());
                    this.noteId = "DeliverNote.No" + specialNoteValue;
                    noteManager.add(this);
                    break;
                }
            }
        }
    }
    public GoodsDeliveryNote(String productName, int quantity,String userNameCreateNote,ProductQueue productType,double originalPrice, double sellPrice){
    }

    public boolean isProductExisted(String productName) {
        return ProductQueueManager
                .getProductQueueList()
                .stream()
                .anyMatch(productQueue -> productQueue.getProductQueueName().equals(productName));
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
                '}' + "\n";
    }
}
