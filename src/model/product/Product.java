package model.product;

import java.time.LocalDate;

public abstract class Product {
    protected String productId;
    protected String productName;
    protected Double productOriginalPrice;
    protected Double productSellPrice;
    protected int productQuantity;
    protected LocalDate manufacturingDate;


    public Product() {
    }

    public Product(String productId, String productName, Double productOriginalPrice, Double productSellPrice, int productQuantity, LocalDate manufacturingDate) {
        this.productId = productId;
        this.productName = productName;
        this.productOriginalPrice = productOriginalPrice;
        this.productSellPrice = productSellPrice;
        this.productQuantity = productQuantity;
        this.manufacturingDate = manufacturingDate;
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

    public Double getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public void setProductOriginalPrice(Double productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public Double getProductSellPrice() {
        return productSellPrice;
    }

    public void setProductSellPrice(Double productSellPrice) {
        this.productSellPrice = productSellPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() {
        return "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productOriginalPrice=" + productOriginalPrice +
                ", productSellPrice=" + productSellPrice +
                ", productQuantity=" + productQuantity +
                ", manufacturingDate=" + manufacturingDate;
    }
}
