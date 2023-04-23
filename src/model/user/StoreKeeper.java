package model.user;

import manager.note_manager.NoteManagerProxy;
import manager.queue.ProductQueueManagerProxy;

public class StoreKeeper extends User {
    public StoreKeeper(String userName, String userPassword, String userFullname) {
        this.userName = userName;
        this.password = userPassword;
        this.userFullName = userFullname;
        this.role = Role.STOREKEEPER;
        this.noteManagerProxy = new NoteManagerProxy(this.role);
        this.productQueueManagerProxy = new ProductQueueManagerProxy(this.role);
    }
}
