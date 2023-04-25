package model.note;

import java.util.Scanner;

public class NoteFactory {
    public Note creatNote(String type, String userNameCreateNote){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the productName");
        String productName = scanner.nextLine();
        System.out.println("Enter the quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        switch (type){
            case "ReceiveNote" -> {
                return new GoodsReceiveNote(productName,quantity,userNameCreateNote);
            }
            case "DeliveryNote" -> {
                return new GoodsDeliveryNote(productName,quantity,userNameCreateNote);
            }
            default -> {
                return null ;
            }
        }
    }
}
