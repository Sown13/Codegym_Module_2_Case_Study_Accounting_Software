package model.product;

import model.queue.ProductQueue;

import java.time.LocalDate;

public class ProductEXPLimited extends Product{
    private int expiryPeriod;
    protected ProductQueue productQueue = new ProductQueue();


    public ProductEXPLimited() {
    }

    public ProductEXPLimited(int expiryPeriod) {
        this.expiryPeriod = expiryPeriod;
    }


    public boolean isExpired(){
       return getManufacturingDate().plusDays(expiryPeriod)
               .isAfter(LocalDate.now());
    }

    public ProductQueue getProductQueue() {
        return productQueue;
    }

    @Override
    public String toString() {
        return "ProductEXPLimited{" + super.toString() +
                "daysUntilExpiry=" + expiryPeriod +
                '}' + "\n";
    }
}
