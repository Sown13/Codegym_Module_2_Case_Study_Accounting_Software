package model.note;

import java.io.Serializable;

public abstract class Note implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    protected String noteId;
    protected String userNameCreateNote;
    protected String reason;
    protected String productName;
    protected int quantity;
    protected double totalAmount;

    public Note() {
    }
    public Note(String productName, int quantity,String userNameCreateNote){
        this.productName = productName;
        this.quantity = quantity;
        this.userNameCreateNote = userNameCreateNote;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getUserNameCreateNote() {
        return userNameCreateNote;
    }

    public void setUserNameCreateNote(String userNameCreateNote) {
        this.userNameCreateNote = userNameCreateNote;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "noteId='" + noteId + '\'' +
                ", userNameCreateNote='" + userNameCreateNote + '\'' +
                ", reason='" + reason + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount ;
    }
}
