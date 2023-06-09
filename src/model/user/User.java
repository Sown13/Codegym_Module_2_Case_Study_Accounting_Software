package model.user;

import service.note_manager.NoteManagerProxy;
import service.queue.ProductQueueManagerProxy;

import java.io.Serial;
import java.io.Serializable;


public abstract class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    protected String userName;
    protected String password;
    protected String userFullName;
    protected String phoneNumber;
    protected Role role;

    protected NoteManagerProxy noteManagerProxy;
    protected ProductQueueManagerProxy productQueueManagerProxy;

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}
