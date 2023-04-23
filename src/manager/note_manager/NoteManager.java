package manager.note_manager;

import model.bill.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteManager implements INoteManager{
    static List<Note> noteList = new ArrayList<>();
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
            switch (choice){
                case "1" -> {
                    noteList = noteList
                            .stream()
                            .filter(note -> !note.getNoteId().equals(noteId))
                            .toList();
                }
                default -> {
                    System.out.println("Canceled");
                }
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
            switch (choice){
                case "1" -> {
                    System.out.println("Enter the new product name");
                    String productName = scanner.nextLine();
                    System.out.println("Enter the new quantity");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    noteEdit.setProductName(productName);
                    noteEdit.setQuantity(quantity);
                    System.out.println("Edit successful");
                }
                default -> {
                    System.out.println("Canceled");
                }
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
}
