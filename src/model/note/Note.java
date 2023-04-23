package model.note;

public abstract class Note {
    protected String noteId;
    protected String userNameCreateNote;
    protected String reason;
    protected String productName;
    protected int quantity;
    protected double totalAmount;

    public Note() {
    }
    public Note(String productName, int quantity){
        this.productName = productName;
        this.quantity = quantity;
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
}