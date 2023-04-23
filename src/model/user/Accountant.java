package model.user;

import manager.note_manager.NoteManagerProxy;
import manager.queue.ProductQueueManagerProxy;

public class Accountant extends User {
    public Accountant(String userName, String userPassword, String userFullname) {
        this.userName = userName;
        this.password = userPassword;
        this.userFullName = userFullname;
        this.role = Role.ACCOUNTANT;
        this.noteManagerProxy = new NoteManagerProxy(this.role);
        this.productQueueManagerProxy = new ProductQueueManagerProxy(this.role);
    }

}
