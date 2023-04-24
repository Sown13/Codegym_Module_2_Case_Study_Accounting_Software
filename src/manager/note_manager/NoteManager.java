package manager.note_manager;

import model.note.GoodsDeliveryNote;
import model.note.GoodsReceiveNote;
import model.note.Note;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NoteManager implements INoteManager{
    private static List<Note> noteList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    @Override
    public void add(Note note) {
        noteList.add(note);
    }

    public boolean isNoteExisted(String noteId){
        return noteList.stream().anyMatch(note -> note.getNoteId().equals(noteId));
    }
    @Override
    public void remove() {
        System.out.println("Remove by id - Please enter the NoteID");
        String noteId = scanner.nextLine();
        if(isNoteExisted(noteId)){
            System.out.println("Are you sure to remove this Note?" + "noteID: " + noteId);
            System.out.println("""
                    1/ Yes, remove it!
                    0/ No, Cancel it!
                    """);
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                noteList = noteList
                        .stream()
                        .filter(note -> !note.getNoteId().equals(noteId))
                        .toList();
            } else {
                System.out.println("Canceled");
            }
        }
    }

    @Override
    public void edit() {
        System.out.println("Remove by id - Please enter the NoteID");
        String noteId = scanner.nextLine();
        if(isNoteExisted(noteId)){
            Note noteEdit = noteList
                    .stream()
                    .filter(note -> note.getNoteId().equals(noteId)).findFirst()
                    .get();
            System.out.println("Are you sure to edit this Note?" + "noteID: " + noteEdit);
            System.out.println("""
                    1/ Yes, Edit it!
                    0/ No, Cancel it!
                    """);
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.println("Enter the new product name");
                String productName = scanner.nextLine();
                System.out.println("Enter the new quantity");
                int quantity = Integer.parseInt(scanner.nextLine());
                noteEdit.setProductName(productName);
                noteEdit.setQuantity(quantity);
                System.out.println("Edit successful");
            } else {
                System.out.println("Canceled");
            }
        }
    }

    @Override
    public void display() {
        int order = 0;
        for (Note note : noteList){
            System.out.println(++order + " - " + note);
        }
    }
    @Override
    public List<Note> getReceiveNote(){
        List<Note> receiveNoteList = noteList
                .stream()
                .filter(note -> note instanceof GoodsReceiveNote)
                .toList();
        System.out.println(receiveNoteList);
        return receiveNoteList;
    }
    @Override
    public List<Note> getDeliveryNote(){
        List<Note> deliveryNoteList = noteList
                .stream()
                .filter(note -> note instanceof GoodsDeliveryNote)
                .toList();
        System.out.println(deliveryNoteList);
        return deliveryNoteList;
    }
    @Override
    public void resetNote(){
        // Need a write method to save old note list to file and read it later
        noteList.clear();
    }
    public List<Note> getNoteList(){
        return noteList;
    }
    public void sortNoteList(){
        noteList.sort(Comparator.comparing(Note::getNoteId));
    }
    public void findNote(){
        System.out.println("Enter keyword");
        String keyWord = scanner.nextLine();
        List<Note> resultList = noteList
                .stream()
                .filter(note -> note.getProductName().contains(keyWord)||
                        note.getNoteId().contains(keyWord))
                .toList();
        resultList.sort(Comparator.comparing(Note::getNoteId));
        int order = 0;
        for (Note note : resultList){
            System.out.println(++order + " - " + note);
        }
    }
}
