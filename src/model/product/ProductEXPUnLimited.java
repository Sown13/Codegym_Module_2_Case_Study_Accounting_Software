package model.product;

public class ProductEXPUnLimited extends Product{
    private static final long serialVersionUID = 6529685098267757690L;

    public ProductEXPUnLimited(String productName) {
        super(productName);
    }

    @Override
    public String toString() {
        return "ProductEXPUnLimited{" + super.toString() + "}" + "\n";
    }
}
