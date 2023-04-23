package model.user;

public class Accountant extends User {
    public Accountant(String userName, String userPassword, String userFullname) {
        this.userName = userName;
        this.password = userPassword;
        this.userFullName = userFullname;
        this.role = Role.ACCOUNTANT;
    }

}
