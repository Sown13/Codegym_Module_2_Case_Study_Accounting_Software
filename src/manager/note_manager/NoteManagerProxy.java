package manager.note_manager;

import model.bill.Note;
import model.user.Role;
import model.user.User;

import java.util.List;

public class NoteManagerProxy extends User implements INoteManager {
    private final Role role;
    private final NoteManager realNoteManager = new NoteManager();
    public NoteManagerProxy(Role userRole){
        this.role = userRole;
    }

    @Override
    public void add(Note note) {
        switch (this.role){
            case ADMIN,SALE_STAFF,STOREKEEPER -> realNoteManager.add(note);
            case ACCOUNTANT -> System.out.println("Unauthorized");
        }
    }

    @Override
    public void remove() {
        switch (this.role){
            case ADMIN,STOREKEEPER -> realNoteManager.remove();
            case SALE_STAFF,ACCOUNTANT -> System.out.println("Unauthorized");
        }
    }

    @Override
    public void edit() {
        switch (this.role) {
            case ADMIN, STOREKEEPER -> realNoteManager.edit();
            case SALE_STAFF,ACCOUNTANT -> System.out.println("Unauthorized");
        }
    }

    @Override
    public void display() {
        switch (this.role) {
            case ADMIN,ACCOUNTANT,STOREKEEPER -> realNoteManager.display();
            case SALE_STAFF -> System.out.println("Unauthorized");
        }
    }

    @Override
    public List<Note> getReceiveNote() {
        switch (this.role) {
            case ADMIN,ACCOUNTANT,STOREKEEPER -> {
                return realNoteManager.getReceiveNote();
            }
            case SALE_STAFF -> {
                System.out.println("Unauthorized");
                return null;
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public List<Note> getDeliveryNote() {
        return realNoteManager.getDeliveryNote();
    }

    @Override
    public void resetNote() {
        switch (this.role){
            case ADMIN,ACCOUNTANT -> realNoteManager.resetNote();
            case STOREKEEPER,SALE_STAFF -> System.out.println("Unauthorized");
        }
    }
}
