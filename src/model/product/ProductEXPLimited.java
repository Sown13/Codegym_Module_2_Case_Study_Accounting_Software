package model.product;

import java.time.LocalDate;

public class ProductEXPLimited extends Product{
    private int expiryPeriod;

    public ProductEXPLimited() {
    }

    public ProductEXPLimited(int expiryPeriod) {
        this.expiryPeriod = expiryPeriod;
    }


    public boolean isExpired(){
       return getManufacturingDate().plusDays(expiryPeriod)
               .isAfter(LocalDate.now());
    }

    @Override
    public String toString() {
        return "ProductEXPLimited{" + super.toString() +
                "daysUntilExpiry=" + expiryPeriod +
                '}' + "\n";
    }
}
