package service.note_manager;

import io.ReadData;
import io.WriteData;
import model.note.GoodsDeliveryNote;
import model.note.GoodsReceiveNote;
import model.note.Note;
import model.note.NoteFactory;
import model.product.Product;
import model.product.ProductEXPLimited;
import service.queue.ProductQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NoteManager implements INoteManager {
    private static List<Note> noteList = new ArrayList<>();

    private static NoteFactory noteFactory = new NoteFactory();

    public void saveDataReceiveNote() {
        WriteData<Note> saver = new WriteData<>();
        String path = "src/io/database/receive_note_save.txt";
        List<Note> receiveNoteList = getReceiveNote();
        saver.writeToSaveFile(receiveNoteList, path);
    }

    public void saveDataDeliveryNote() {
        WriteData<Note> saver = new WriteData<>();
        String path = "src/io/database/delivery_note_save.txt";
        List<Note> deliveryNoteList = getDeliveryNote();
        saver.writeToSaveFile(deliveryNoteList, path);
    }

    public void saveNote() {
        saveDataReceiveNote();
        saveDataDeliveryNote();
    }

    public static void loadNoteList() {
        ReadData<Note> loader = new ReadData<>();
        List<Note> part1 = loader.loadListData("src/io/database/receive_note_save.txt");
        List<Note> part2 = loader.loadListData("src/io/database/delivery_note_save.txt");
        for (Note note : part1) {
            if (((GoodsReceiveNote) note).getThisQueueOfNoteFromQueue() != null) {
                Note tempNote = noteFactory.createNoteAuto("ReceiveNote", note.getProductName(), note.getQuantity(), note.getUserNameCreateNote()
                        , ((GoodsReceiveNote) note).getThisQueueOfNoteFromQueue()
                        , ((GoodsReceiveNote) note).getThisQueueOfNoteFromQueue().getTotalOriginalPrice()
                        , ((GoodsReceiveNote) note).getThisQueueOfNoteFromQueue().getRepresentationProduct().getProductSellPrice());
                noteList.add(tempNote);
            } else {
                noteList.add(note);
            }
        }
        Product uselessProduct = new ProductEXPLimited("useless");
        ProductQueue uselessQueue = new ProductQueue(0, uselessProduct);
        for (Note note : part2) {
            Note tempNote = noteFactory.createNoteAuto("DeliveryNote", note.getProductName(), note.getQuantity(), note.getUserNameCreateNote(), uselessQueue, 0d, 0d);
            noteList.add(note);
        }
        System.out.println("Note imported!");
    }

    @Override
    public void add(Note note) {
        noteList.add(note);
        saveNote();
    }

    public boolean isNoteExisted(String noteId) {
        return noteList.stream().anyMatch(note -> note.getNoteId().equals(noteId));
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Remove by id - Please enter the NoteID");
        String noteId = scanner.nextLine();
        if (isNoteExisted(noteId)) {
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
        saveNote();
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Remove by id - Please enter the NoteID");
        String noteId = scanner.nextLine();
        if (isNoteExisted(noteId)) {
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
        saveNote();
    }

    @Override
    public void display() {
        int order = 0;
        for (Note note : noteList) {
            System.out.println(++order + " - " + note);
        }
    }

    @Override
    public List<Note> getReceiveNote() {
        List<Note> receiveNoteList = noteList
                .stream()
                .filter(note -> note instanceof GoodsReceiveNote)
                .toList();
//        System.out.println(receiveNoteList);
        return receiveNoteList;
    }

    @Override
    public List<Note> getDeliveryNote() {
        List<Note> deliveryNoteList = noteList
                .stream()
                .filter(note -> note instanceof GoodsDeliveryNote)
                .toList();
//        System.out.println(deliveryNoteList);
        return deliveryNoteList;
    }

    @Override
    public void resetNote() {
        noteList.clear();
        saveNote();
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void sortNoteList() {
        noteList.sort(Comparator.comparing(Note::getNoteId));
    }

    public void seachNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter keyword");
        String keyWord = scanner.nextLine();
        List<Note> resultList = new ArrayList<>(noteList
                .stream()
                .filter(note -> note.getProductName().toLowerCase().contains(keyWord.toLowerCase()) ||
                        note.getNoteId().toLowerCase().contains(keyWord.toLowerCase()))
                .toList());
        resultList.sort(Comparator.comparing(Note::getNoteId));
        int order = 0;
        for (Note note : resultList) {
            System.out.println(++order + " - " + note);
        }
    }

}
