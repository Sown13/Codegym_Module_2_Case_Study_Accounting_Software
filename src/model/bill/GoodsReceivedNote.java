package model.bill;

import model.product.Product;

//Phiếu nhập kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsReceivedNote {
    private static int specialNoteValue = 10_000;
    private String noteId;
    private Product productReceive;
    private String receiveUserName;
    private String reason;
    private String productId;
    private String productName;
    private int quantityReceive;
    private double productReceivePrice;

    public GoodsReceivedNote() {
        specialNoteValue++;
        this.noteId = "ReceiverNote.No" + specialNoteValue;
    }
}
