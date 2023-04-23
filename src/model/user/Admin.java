package model.user;

import manager.note_manager.NoteManagerProxy;
import manager.queue.ProductQueueManagerProxy;


public class Admin extends User{
    private static final Admin admin = new Admin();
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

}
