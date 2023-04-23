package model.user;

public class Admin extends User{
    private static final Admin admin = new Admin();
    private Admin() {
        this.userName = "admin";
        this.password = "admin";
        this.userFullName = "admin";
        this.role = Role.ADMIN;
    }
    public static Admin getAdmin(){
        return admin;
    }
}
