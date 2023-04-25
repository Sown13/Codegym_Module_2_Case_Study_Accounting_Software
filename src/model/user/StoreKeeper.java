package model.user;

import service.note_manager.NoteManagerProxy;
import service.queue.ProductQueueManagerProxy;

public class StoreKeeper extends User {
    private static final long serialVersionUID = 6529685098267757690L;
    public StoreKeeper(String userName, String userPassword, String userFullname) {
        this.userName = userName;
        this.password = userPassword;
        this.userFullName = userFullname;
        this.role = Role.STOREKEEPER;
        this.noteManagerProxy = new NoteManagerProxy(this.role);
        this.productQueueManagerProxy = new ProductQueueManagerProxy(this.role);
    }
}
