package service.note_manager;

import service.IGeneralManager;
import model.note.Note;

import java.util.List;

public interface INoteManager extends IGeneralManager<Note> {
    List<Note> getReceiveNote();
    List<Note> getDeliveryNote();
    void resetNote();
}
