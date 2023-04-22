package model.sout;

public class NotifyForm {
    public static void textNoteEditByName(){
        System.out.println("""
                Please enter the input following order (divided by ENTER):
                1 - New product name (String)
                2 - New product detail (String)
                3 - New product Sell Price (Double)
                """);
    }
}
