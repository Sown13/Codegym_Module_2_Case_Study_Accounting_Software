package model.bill;

import manager.product.ProductQueue;
import manager.product.ProductQueueManager;
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
        productQueueList.add(new ProductQueue(quantity,tempProduct));
    }
}
