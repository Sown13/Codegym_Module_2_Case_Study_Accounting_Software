package model.user;

import java.io.Serial;
import java.io.Serializable;

public class UserFactory implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    public User createUser(String role,String userName, String password,String userFullName){
        switch (role){
            case "SaleStaff" -> {
                return new SaleStaff(userName, password, userFullName);
            }
            case "StoreKeeper" -> {
                return new StoreKeeper(userName, password, userFullName);
            }
            case "Accountant" -> {
                return new Accountant(userName, password, userFullName);
            }
            default -> {
                return null;
            }
        }
    }
}
