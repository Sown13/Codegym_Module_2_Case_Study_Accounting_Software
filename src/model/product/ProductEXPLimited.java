package model.product;


import java.time.LocalDate;

public class ProductEXPLimited extends Product{
    private static final long serialVersionUID = 6529685098267757690L;
    private int expiryPeriod;

    public ProductEXPLimited(String name) {
        super(name);
    }

//    public ProductEXPLimited(int expiryPeriod) {
//        this.expiryPeriod = expiryPeriod;
//    }


//    public boolean isExpired(){
//       return getManufacturingDate().plusDays(expiryPeriod)
//               .isAfter(LocalDate.now());
//    }
//


    @Override
    public String toString() {
        return "ProductEXPLimited{" + super.toString() + "," +
                " daysUntilExpiry=" + expiryPeriod +
                '}' + "\n";
    }
}
