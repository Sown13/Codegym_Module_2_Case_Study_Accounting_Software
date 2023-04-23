package model.bill;

//import model.product.ProductFactory;

import model.product.Product;

//Phiếu xuất kho, sẽ cần lưu lại sau mỗi lần lập;
public class GoodsDeliveryNote {
    private static int specialNoteValue = 10_000;
    private String noteId;
    private Product productDelivery;
    private String deliveryUserName;
    private String reason;
    private String productId;
    private String productName;
    private int quantityDelivery;
    private double productDeliveryPrice;

    public GoodsDeliveryNote() {
        specialNoteValue++;
        this.noteId = "DeliverNote.No" + specialNoteValue;
    }

    public Product getProductDelivery() {
        return productDelivery;
    }

    public void setProductDelivery(Product productDelivery) {
        this.productDelivery = productDelivery;
    }

    public String getDeliveryUserName() {
        return deliveryUserName;
    }

    public void setDeliveryUserName(String deliveryUserName) {
        this.deliveryUserName = deliveryUserName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityDelivery() {
        return quantityDelivery;
    }

    public void setQuantityDelivery(int quantityDelivery) {
        this.quantityDelivery = quantityDelivery;
    }

    public double getProductDeliveryPrice() {
        return productDeliveryPrice;
    }

    public void setProductDeliveryPrice(double productDeliveryPrice) {
        this.productDeliveryPrice = productDeliveryPrice;
    }
}
