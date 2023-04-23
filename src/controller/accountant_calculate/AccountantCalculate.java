package controller.accountant_calculate;

import manager.note_manager.NoteManager;
import manager.queue.ProductQueueManager;
import model.note.Note;

public class AccountantCalculate {
    NoteManager noteManager;
    ProductQueueManager productQueueManager;
    public double getTotalBuyingAmount(){
        double totalBuyingAmount = 0;
        for(Note note : noteManager.getReceiveNote()){
            totalBuyingAmount += note.getTotalAmount();
        }
        return totalBuyingAmount;
    }

    public double getTotalSellingAmount(){
        double totalSellingAmount = 0;
        for (Note note : noteManager.getDeliveryNote()){
            totalSellingAmount += note.getTotalAmount();
        }
        return totalSellingAmount;
    }
    public double getTotalCurrentStorageAmount(){
       return productQueueManager.getTotalCurrentOriginalPrice();
    }

}
