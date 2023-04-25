package model.note;

import service.note_manager.NoteManager;
import service.queue.ProductQueue;
import service.queue.ProductQueueManager;
import model.product.Product;
import model.product.ProductFactory;

import java.io.Serial;
import java.util.Scanner;

//Phiếu nhập kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsReceiveNote extends Note {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    ProductFactory productFactory = new ProductFactory();
    static ProductQueueManager productQueueList = new ProductQueueManager();

    public static int specialNoteValue = 10_000;

    public GoodsReceiveNote(String productName, int quantity,String userNameCreateNote) {
       super(productName,quantity,userNameCreateNote);
        specialNoteValue++;
        this.noteId = "ReceiverNote.No" + specialNoteValue;
        System.out.println("""
                Enter the type of product
                1/ limited exp
                2/ unlimited exp
                """);
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        Product tempProduct;
        if (choice.equals("1")) {
            tempProduct = productFactory.makeProduct("limited", productName);
        } else {
            tempProduct = productFactory.makeProduct("unlimited", productName);
        }
        System.out.println("Enter the original price");
        double originalPrice = Double.parseDouble(scanner.nextLine());
        tempProduct.setProductOriginalPrice(originalPrice);
        System.out.println("Enter the sell price");
        double sellPrice = Double.parseDouble(scanner.nextLine());
        tempProduct.setProductSellPrice(sellPrice);
        productQueueList.add(new ProductQueue(quantity,tempProduct));
        NoteManager noteManager = new NoteManager();
        this.totalAmount = tempProduct.getProductOriginalPrice() * quantity;
        noteManager.add(this);
    }

    @Override
    public String toString() {
        return "GoodsReceiveNote{" +
                ", noteId='" + noteId + '\'' +
                ", userNameCreateNote='" + userNameCreateNote + '\'' +
                ", reason='" + reason + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}' + "\n";
    }
}
