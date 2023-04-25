package model.user;

import service.note_manager.NoteManagerProxy;
import service.queue.ProductQueueManagerProxy;

import java.io.Serializable;


public class Admin extends User {
    private static final Admin admin = new Admin();
    private static double money;
    private static double capital;
    private Admin() {
        this.userName = "admin";
        this.password = "admin";
        this.userFullName = "admin";
        this.role = Role.ADMIN;
        this.noteManagerProxy = new NoteManagerProxy(this.role);
        this.productQueueManagerProxy = new ProductQueueManagerProxy(this.role);
    }
    public static Admin getAdmin(){
        return admin;
    }

    public static double getMoney() {
        return money;
    }

    public static void setMoney(double money) {
        Admin.money = money;
    }

    public static double getCapital() {
        return capital;
    }

    public static void setCapital(double capital) {
        Admin.capital = capital;
    }
}
