package model.product;


import java.time.LocalDate;
import java.util.PriorityQueue;

public abstract class Product {
    private static int hiddenSpecialValue = 10_000;
    protected String productId;
    protected String productName;
    protected String productDetail;
    protected Double productOriginalPrice;
    protected Double productSellPrice;
//    protected int productQuantity;
//    protected PriorityQueue<Product> productQueue = new PriorityQueue<>();

//    protected LocalDate manufacturingDate;


    public Product(String productName) {
        ++hiddenSpecialValue;
        this.productId = "" + hiddenSpecialValue;
        this.productName = productName;
    }

    public Product(String productId, String productName, String productDetail, Double productOriginalPrice, Double productSellPrice, int productQuantity, LocalDate manufacturingDate) {
        this.productId = productId;
        this.productName = productName;
        this.productDetail = productDetail;
        this.productOriginalPrice = productOriginalPrice;
        this.productSellPrice = productSellPrice;
//        this.productQuantity = productQuantity;
//        for(int i =0; i< productQuantity;i++) {
//            this.productQueue.poll();
//        }
//        this.manufacturingDate = manufacturingDate;
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

//    public int getProductQuantity() {
//        this.productQuantity = this.productQueue.size();
//        return productQuantity;
//    }
//
//    public void setProductQuantity(int productQuantity) {
//        this.productQuantity = productQuantity;
//    }

//    public LocalDate getManufacturingDate() {
//        return manufacturingDate;
//    }
//
//    public void setManufacturingDate(LocalDate manufacturingDate) {
//        this.manufacturingDate = manufacturingDate;
//    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

//    public PriorityQueue<Product> getProductQueue() {
//        return productQueue;
//    }
    @Override
    public String toString() {
        return "productId: '" + productId + '\'' +
                ", productName: '" + productName + '\'' +
                ", productOriginalPrice: " + productOriginalPrice +
                ", productSellPrice: " + productSellPrice +
                ", productDetail: " + productDetail;
//              +  ", productQuantity=" + productQuantity +
//                ", manufacturingDate=" + manufacturingDate;
    }
}
