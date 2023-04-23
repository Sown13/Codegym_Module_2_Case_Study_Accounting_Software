package model.user;

public class SaleStaff extends User{
    public SaleStaff(String userName, String userPassword, String userFullname) {
        this.userName = userName;
        this.password = userPassword;
        this.userFullName = userFullname;
        this.role = Role.SALE_STAFF;
    }
}
