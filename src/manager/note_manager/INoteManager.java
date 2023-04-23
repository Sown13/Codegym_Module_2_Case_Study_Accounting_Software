package manager.note_manager;

import manager.IGeneralManager;
import model.bill.Note;

import java.util.List;

public interface INoteManager extends IGeneralManager<Note> {
    List<Note> getReceiveNote();
    List<Note> getDeliveryNote();
    void resetNote();
}
