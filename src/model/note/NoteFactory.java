package model.note;

import java.io.Serial;
import java.io.Serializable;
import java.util.Scanner;

public class NoteFactory implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    public Note createNote(String type, String userNameCreateNote) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the productName");
        String productName = scanner.nextLine();
        System.out.println("Enter the quantity");
        int quantity = 0;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Wrong type input, quantity automatic converted to 0");
        }
        switch (type) {
            case "ReceiveNote" -> {
                return new GoodsReceiveNote(productName, quantity, userNameCreateNote);
            }
            case "DeliveryNote" -> {
                return new GoodsDeliveryNote(productName, quantity, userNameCreateNote);
            }
            default -> {
                return null;
            }
        }
    }
}
