package model.product;


import java.io.Serial;
import java.io.Serializable;


public abstract class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    private static int hiddenSpecialValue = 10_000;
    protected String productId;
    protected String productName;
    protected String productDetail = "";
    protected Double productOriginalPrice = 0d;
    protected Double productSellPrice = 0d;



    public Product(String productName) {
        ++hiddenSpecialValue;
        this.productId = "" + hiddenSpecialValue;
        this.productName = productName;
    }

    public Product(String productId, String productName, String productDetail, Double productOriginalPrice, Double productSellPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDetail = productDetail;
        this.productOriginalPrice = productOriginalPrice;
        this.productSellPrice = productSellPrice;
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


    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public String toString() {
        return "productId: '" + productId + '\'' +
                ", productName: '" + productName + '\'' +
                ", productOriginalPrice: " + productOriginalPrice +
                ", productSellPrice: " + productSellPrice +
                ", productDetail: " + productDetail;
    }
}
