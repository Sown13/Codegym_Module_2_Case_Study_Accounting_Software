package model.bill;

import java.util.Scanner;

public class NoteFactory {
    Scanner scanner = new Scanner(System.in);
    public Note creatNote(String type){
        System.out.println("Enter the productName");
        String productName = scanner.nextLine();
        System.out.println("Enter the quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        switch (type){
            case "ReceiveNote" -> {
                return new GoodsReceiveNote(productName,quantity);
            }
            case "DeliveryNote" -> {
                return new GoodsDeliveryNote(productName,quantity);
            }
            default -> {
                return null ;
            }
        }
    }
}
