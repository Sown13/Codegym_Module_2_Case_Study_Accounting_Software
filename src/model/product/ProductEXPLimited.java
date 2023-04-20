package model.product;

import java.time.LocalDate;
import java.util.Date;

public class ProductEXPLimited extends Product{
    private int daysUntilExpiry;

    public ProductEXPLimited() {
    }

    public ProductEXPLimited(int daysUntilExpiry) {
        this.daysUntilExpiry = daysUntilExpiry;
    }


    public boolean isExpired(){
       return getManufacturingDate().plusDays(daysUntilExpiry)
               .isAfter(LocalDate.now());
    }

    @Override
    public String toString() {
        return "ProductEXPLimited{" + super.toString() +
                "daysUntilExpiry=" + daysUntilExpiry +
                '}' + "\n";
    }
}
