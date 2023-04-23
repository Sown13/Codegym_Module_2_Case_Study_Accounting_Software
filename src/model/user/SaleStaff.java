package model.user;

import manager.note_manager.NoteManagerProxy;
import manager.queue.ProductQueueManagerProxy;

public class SaleStaff extends User{
    public SaleStaff(String userName, String userPassword, String userFullname) {
        this.userName = userName;
        this.password = userPassword;
        this.userFullName = userFullname;
        this.role = Role.SALE_STAFF;
        this.noteManagerProxy = new NoteManagerProxy(this.role);
        this.productQueueManagerProxy = new ProductQueueManagerProxy(this.role);
    }
}
