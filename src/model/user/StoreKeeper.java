package model.user;

public class StoreKeeper extends User {
    public StoreKeeper(String userName, String userPassword, String userFullname) {
        this.userName = userName;
        this.password = userPassword;
        this.userFullName = userFullname;
        this.role = Role.STOREKEEPER;
    }
}
