package view.menu;

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
                    currentRole = checkCondition.getValue().getRole();
                    menuCondition = false;
                    switch (checkCondition.getValue().getRole()){
                        case ADMIN -> {
                            Menu.adminMenu();
//                            currentRole = Role.ADMIN;
                        }
                        case ACCOUNTANT -> {
                            Menu.accountantMenu();
//                            currentRole = Role.ACCOUNTANT;
                        }
                        case STOREKEEPER -> {
                            Menu.storeKeeperMenu();
//                            currentRole = Role.STOREKEEPER;
                        }
                        case SALE_STAFF -> {
                            Menu.saleStaffMenu();
//                            currentRole = Role.SALE_STAFF;
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
                    0/ Back to main menu
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> Menu.showProductMenu();
                case "2" -> Menu.createNoteMenu();
                case "3" -> productQueueManager.searchProduct();
                case "4" -> productQueueManager.remove();
                case "0" -> Menu.backToRoleMenu();
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
                0/ Back to main menu
                """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> productQueueManager.display();
                case "2" -> System.out.println(productQueueManager.getExpLimitedList());
                case "3" -> System.out.println(productQueueManager.getEXPUnlimitedList());
                case "4" -> productQueueManager.sortByName();
                case "0" -> Menu.backToRoleMenu();
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
                    0/ Back to main menu
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> noteManager.display();
                case "2" -> System.out.println(noteManager.getReceiveNote());
                case "3" -> System.out.println(noteManager.getDeliveryNote());
                case "4" -> noteManager.findNote();
                case "0" -> Menu.backToRoleMenu();
            }
        }
        while (menuCondition);
    }
    public static void userMenu(){
        menuCondition = true;
        do {
            System.out.println("""
                    1/ Show user list
                    2/ Create new user
                    3/ Find user
                    4/ Remove user
                    0/ Back to previous
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> Menu.showUserListMenu();
                case "2" -> {
                    System.out.println("Enter the full name");
                    String fullName = scanner.nextLine();
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter the User Name");
                    String userName = scanner.nextLine();
                    System.out.println("Enter your password");
                    String userPassword = scanner.nextLine();
                    System.out.println("Re-enter your password");
                    String passwordCheck = scanner.nextLine();
                    while (!passwordCheck.equals(userPassword)){
                        System.out.println("password not right, re-enter your password");
                        passwordCheck = scanner.nextLine();
                    }
                    System.out.println("""
                    Choose user role :
                    1/ SaleStaff
                    2/ StoreKeeper
                    3/ Accountant
                    """);
                    User tempUser;
                    choice = scanner.nextLine();
                    switch (choice) {
                        case "1" -> {
                            tempUser = userFactory.createUser("SaleStaff", userName, userPassword, fullName);
                            tempUser.setPhoneNumber(phoneNumber);
                            userManager.add(tempUser);
                        }
                        case "2" -> {
                            tempUser = userFactory.createUser("StoreKeeper", userName, userPassword, fullName);
                            tempUser.setPhoneNumber(phoneNumber);
                            userManager.add(tempUser);
                        }
                        case "3" -> {
                            tempUser = userFactory.createUser("Accountant", userName, userPassword, fullName);
                            tempUser.setPhoneNumber(phoneNumber);
                            userManager.add(tempUser);
                        }
                    }
                }
                case "3" -> System.out.println("Funtion is in develop, please comeback later~ Thank you!");
                case "4" -> userManager.remove();
                case "0" -> Menu.adminMenu();
            }
        }
        while (menuCondition);
    }

    public static void showUserListMenu(){
        menuCondition = true;
        do {
            System.out.println("""
                    1/ Show all user
                    2/ Show accountant user
                    3/ Show Store Keeper user
                    4/ Show Sale Staff user
                    0/ Back to previous
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> userManager.display();
                case "2","3","4" -> System.out.println("Funtion is in develop, please comeback later~ Thank you!");
                case "0" -> Menu.userMenu();
            }
        }
        while (menuCondition);
    }

    public static void storeKeeperMenu() {
        menuCondition = true;
        Menu.productMenu();
    }


    public static void saleStaffMenu() {
        menuCondition = true;
        do {
            System.out.println("""
                    1/ Show product
                    2/ Create Receive Note
                    0/ Log out
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> Menu.showProductMenu();
                case "2" -> noteFactory.creatNote("ReceiveNote");
                case "0" -> Menu.startMenu();
            }
        }
        while (menuCondition);
    }

    public static void accountantMenu() {
        menuCondition = true;
        do {
            System.out.println("""
                    1/ Show product
                    2/ Show note list
                    3/ Business calculate
                    0/ Log out
                    """);
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> Menu.showProductMenu();
                case "2" -> Menu.showNoteList();
                case "3" -> businessCalculate.getBusinessResult();
                case "0" -> Menu.startMenu();
            }
        }
        while (menuCondition);
    }
}
