package view.menu.bill;

import controller.accountant_calculate.AccountantCalculate;
import manager.note_manager.NoteManager;
import manager.queue.ProductQueueManager;
import manager.user.UserManager;
import model.note.NoteFactory;
import model.user.Role;
import model.user.User;
import model.user.UserFactory;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static Role currentRole = null;
    private static boolean menuCondition;
    private static UserFactory userFactory = new UserFactory();
    private static NoteFactory noteFactory = new NoteFactory();
    private static UserManager userManager = new UserManager();
    private static ProductQueueManager productQueueManager = new ProductQueueManager();
    private static NoteManager noteManager = new NoteManager();
    private static AccountantCalculate businessCalculate = new AccountantCalculate();
    static Scanner scanner = new Scanner(System.in);
//    public static void mainMenu(){
//        do {
//            System.out.println("""
//                    1/
//                    """);
//        }
//        while (true);
//    }
    private static void backToRoleMenu(){
        switch (currentRole){
            case ADMIN -> Menu.adminMenu();
            case ACCOUNTANT -> Menu.accountantMenu();
            case STOREKEEPER -> Menu.storeKeeperMenu();
            case SALE_STAFF -> Menu.saleStaffMenu();
        }
    }

    public static void startMenu() {
        menuCondition = true;
        currentRole = null;
        do {
            System.out.println("""
                    1/ Login                
                    0/ Exit
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> Menu.loginMenu();
                case "0" -> System.exit(0);
            }
        }
        while (menuCondition);
    }
//                case "2" -> {
//                    System.out.println("Enter the full name");
//                    String fullName = scanner.nextLine();
//                    System.out.println("Enter the phone number");
//                    String phoneNumber = scanner.nextLine();
//                    System.out.println("Enter the User Name");
//                    String userName = scanner.nextLine();
//                    // Need a method to check isExistUserName
//                    System.out.println("Enter your password");
//                    String userPassword = scanner.nextLine();
//                    System.out.println("Re-enter your password");
//                    String passwordCheck = scanner.nextLine();
//                    while (!passwordCheck.equals(userPassword)){
//                        System.out.println("password not right, re-enter your password");
//                        passwordCheck = scanner.nextLine();
//                    }
//                    System.out.println("""
//                    Choose user role :
//                    1/ SaleStaff
//                    2/ StoreKeeper
//                    3/ Accountant
//                    """);
//                    choice = scanner.nextLine();
//                    switch (choice) {
//                        case "1" -> userFactory.createUser("SaleStaff", userName, userPassword, fullName);
//                        case "2" -> userFactory.createUser("StoreKeeper", userName, userPassword, fullName);
//                        case "3" -> userFactory.createUser("Accountant", userName, userPassword, fullName);
//                    }
//                }


    public static void loginMenu() {
        menuCondition = true;
        do {
            System.out.println("Enter the User Name");
            String userName = scanner.nextLine();
            System.out.println("Enter the Password");
            String userPassword = scanner.nextLine();
            for (Map.Entry<String, User> checkCondition : UserManager.getUserList().entrySet()) {
                if (userName.equals(checkCondition.getKey()) &&
                        userPassword.equals(checkCondition.getValue().getPassword())) {
                    System.out.println("Loged in as " + checkCondition.getValue().getRole());
                    menuCondition = false;
                    switch (checkCondition.getValue().getRole()){
                        case ADMIN -> {
                            Menu.adminMenu();
                            currentRole = Role.ADMIN;
                        }
                        case ACCOUNTANT -> {
                            Menu.accountantMenu();
                            currentRole = Role.ACCOUNTANT;
                        }
                        case STOREKEEPER -> {
                            Menu.storeKeeperMenu();
                            currentRole = Role.STOREKEEPER;
                        }
                        case SALE_STAFF -> {
                            Menu.saleStaffMenu();
                            currentRole = Role.SALE_STAFF;
                        }
                    }
                    break;
                }
                else {
                    menuCondition = true;
                }
                if (menuCondition){
                    System.out.println("Wrong user or password! Please try again");
                }
            }
        } while (menuCondition);

    }

    public static void adminMenu() {
        menuCondition = true;
        do{
            System.out.println("""
                    1/ Product Manager
                    2/ Business Manager
                    3/ User Manager
                    0/ Log out
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> Menu.productMenu();
                case "2" -> Menu.businessMenu();
                case "3" -> Menu.userMenu();
                case "0" -> Menu.startMenu();
            }
        }
        while (menuCondition);

    }


    public static void productMenu(){
        menuCondition = true;
        do {
            System.out.println("""
                    1/ Show Product
                    2/ Create Note
                    3/ Find Product
                    4/ Remove a Product
                    0/ Back to previous
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> Menu.showProductMenu();
                case "2" -> Menu.createNoteMenu();
                case "3" -> productQueueManager.searchProduct();
                case "4" -> productQueueManager.remove();
                case "0" -> adminMenu();
            }
        }
        while (menuCondition);
    }

    public static void showProductMenu(){
        menuCondition = true;
        do {
            System.out.println("""
                1/ Show all
                2/ Show EXP Limited Product
                3/ Show EXP Unlimited Product
                4/ Sort
                0/ Back to previous
                """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> productQueueManager.display();
                case "2" -> System.out.println(productQueueManager.getExpLimitedList());
                case "3" -> System.out.println(productQueueManager.getEXPUnlimitedList());
                case "4" -> productQueueManager.sortByName();
                case "0" -> Menu.productMenu();
            }
        }
        while (menuCondition);
    }

    public static void createNoteMenu(){
        menuCondition = true;
        do {
            System.out.println("""
                    1/ Create Goods Receive Note
                    2/ Create Goods Delivery Note
                    0/ Back to previous
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> noteFactory.creatNote("ReceiveNote");
                case "2" -> noteFactory.creatNote("DeliveryNote");
                case "0" -> Menu.productMenu();
            }
        }
        while (menuCondition);
    }
    public static void businessMenu(){
        menuCondition = true;
        do {
            System.out.println("""
                    1/ Show note list
                    2/ Business Result
                    3/ Add money
                    0/ Back to previous
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> Menu.showNoteList();
                case "2" -> businessCalculate.getBusinessResult();
                case "3" -> System.out.println("Function is in maintain, please comback later~!");
                case "0" -> Menu.backToRoleMenu();
            }
        }
        while (menuCondition);
    }
    public static void showNoteList(){
        menuCondition = true;
        do {
            System.out.println("""
                    1/ Show all note list
                    2/ Show receive note list
                    3/ Show delivery note list
                    4/ Find note
                    0/ Back to previous menu
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> noteManager.display();
                case "2" -> System.out.println(noteManager.getReceiveNote());
                case "3" -> System.out.println(noteManager.getDeliveryNote());
                case "4" -> noteManager.findNote();
                case "0" -> Menu.businessMenu();
            }
        }
        while (menuCondition);
    }
    public static void userMenu(){

    }

    public static void storeKeeperMenu() {

    }


    public static void saleStaffMenu() {

    }

    public static void accountantMenu() {

    }
}
