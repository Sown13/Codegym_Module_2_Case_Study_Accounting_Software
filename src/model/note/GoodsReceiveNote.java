package model.note;

import manager.note_manager.NoteManager;
import manager.queue.ProductQueue;
import manager.queue.ProductQueueManager;
import model.product.Product;
import model.product.ProductFactory;

import java.util.Scanner;

//Phiếu nhập kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsReceiveNote extends Note {
    ProductFactory productFactory = new ProductFactory();
    ProductQueueManager productQueueList = new ProductQueueManager();
    Scanner scanner = new Scanner(System.in);

    private static int specialNoteValue = 10_000;

    public GoodsReceiveNote(String productName, int quantity) {
       super(productName,quantity);
        specialNoteValue++;
        this.noteId = "ReceiverNote.No" + specialNoteValue;
        System.out.println("""
                Enter the type of product
                1/ limited exp
                2/ unlimited exp
                """);
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
}
