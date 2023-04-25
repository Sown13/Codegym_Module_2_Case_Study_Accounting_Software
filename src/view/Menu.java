package view;

import controller.accountant_calculate.AccountantCalculate;
import model.note.NoteFactory;
import model.user.Role;
import model.user.User;
import model.user.UserFactory;
import service.note_manager.NoteManager;
import service.queue.ProductQueueManager;
import service.user.UserManager;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static Role currentRole = null;
    private static String currentUser = null;
    private static String currentUserFullName = null;
    private static boolean menuCondition;
    private static UserFactory userFactory = new UserFactory();
    private static NoteFactory noteFactory = new NoteFactory();
    private static UserManager userManager = new UserManager();
    private static ProductQueueManager productQueueManager = new ProductQueueManager();
    private static NoteManager noteManager = new NoteManager();
    private static AccountantCalculate businessCalculate = new AccountantCalculate();
    static Scanner scanner = new Scanner(System.in);

    private static void backToRoleMenu() {
        switch (currentRole) {
            case ADMIN -> Menu.adminMenu();
            case ACCOUNTANT -> Menu.accountantMenu();
            case STOREKEEPER -> Menu.storeKeeperMenu();
            case SALE_STAFF -> Menu.saleStaffMenu();
        }
    }

    private static void loadSave() {
        UserManager.loadUser();
        NoteManager.loadNoteList();
    }

    public static void startMenu() {
        loadSave();
        menuCondition = true;
        currentRole = null;
        currentUser = null;
        currentUserFullName = null;
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

    public static void drawHeader() {
        System.out.printf("""
                _______________________________________________________________________________________________
                | Current User: %s           
                | Role: %s         
                | Name: %s          
                ----------------------------------
                """, currentUser, currentRole, currentUserFullName);
    }


    public static void loginMenu() {
        menuCondition = true;
        do {
            System.out.println("Enter the User Name");
            String userName = scanner.nextLine();
            System.out.println("Enter the Password");
            String userPassword = scanner.nextLine();
            for (Map.Entry<String, User> checkConditionEntry : UserManager.getUserList().entrySet()) {
                if (userName.equals(checkConditionEntry.getValue().getUserName()) &&
                        userPassword.equals(checkConditionEntry.getValue().getPassword())) {
                    System.out.println("Logged in as " + checkConditionEntry.getValue().getRole());
                    currentRole = checkConditionEntry.getValue().getRole();
                    currentUser = checkConditionEntry.getValue().getUserName();
                    currentUserFullName = checkConditionEntry.getValue().getUserFullName();
                    menuCondition = false;
                    switch (checkConditionEntry.getValue().getRole()) {
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
                } else {
                    menuCondition = true;
                }
            }
            if (menuCondition) {
                System.out.println("Wrong user or password! Please try again");
                Menu.startMenu();
            }
        } while (menuCondition);

    }

    public static void adminMenu() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Product Manager              |
                    | 2/ Business Manager             |
                    | 3/ User Manager                 |
                    | 0/ Log out                      |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> Menu.productMenu();
                case "2" -> Menu.businessMenu();
                case "3" -> Menu.userMenu();
                case "0" -> Menu.startMenu();
            }
        }
        while (menuCondition);

    }


    public static void productMenu() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Show Product                 |
                    | 2/ Create Note                  |
                    | 3/ Find Product                 |
                    | 4/ Remove a Product             |
                    | 0/ Back to previous menu //     |
                    | <Logout if you are StoreKeeper> |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> Menu.showProductMenu();
                case "2" -> Menu.createNoteMenu();
                case "3" -> productQueueManager.searchProduct();
                case "4" -> productQueueManager.remove();
                case "0" -> {
                    switch (currentRole){
                        case STOREKEEPER -> Menu.startMenu();
                        default -> Menu.backToRoleMenu();
                    }
                }
            }
        }
        while (menuCondition);
    }

    public static void showProductMenu() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Show all                     |
                    | 2/ Show EXP Limited Product     |
                    | 3/ Show EXP Unlimited Product   |
                    | 4/ Sort                         |
                    | 0/ Back to main menu            |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> productQueueManager.display();
                case "2" -> System.out.println(productQueueManager.getExpLimitedList());
                case "3" -> System.out.println(productQueueManager.getEXPUnlimitedList());
                case "4" -> productQueueManager.sortByName();
                case "0" -> Menu.backToRoleMenu();
            }
        }
        while (menuCondition);
    }

    public static void createNoteMenu() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Create Goods Receive Note    |
                    | 2/ Create Goods Delivery Note   |
                    | 0/ Back to previous             |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> noteFactory.creatNote("ReceiveNote", currentUser);
                case "2" -> noteFactory.creatNote("DeliveryNote", currentUser);
                case "0" -> Menu.productMenu();
            }
        }
        while (menuCondition);
    }

    public static void businessMenu() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Show note list               |
                    | 2/ Business Result              |
                    | 3/ Add money                    |
                    | 0/ Back to previous             |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> Menu.showNoteList();
                case "2" -> businessCalculate.getBusinessResult();
                case "3" -> System.out.println("Function is in maintain, please comeback later~!");
                case "0" -> Menu.backToRoleMenu();
            }
        }
        while (menuCondition);
    }

    public static void showNoteList() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Show all note list           |
                    | 2/ Show receive note list       |
                    | 3/ Show delivery note list      |
                    | 4/ Find note                    |
                    | 0/ Back to main menu            |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> noteManager.display();
                case "2" -> System.out.println(noteManager.getReceiveNote());
                case "3" -> System.out.println(noteManager.getDeliveryNote());
                case "4" -> noteManager.seachNote();
                case "0" -> Menu.backToRoleMenu();
            }
        }
        while (menuCondition);
    }

    public static void userMenu() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Show user list               |
                    | 2/ Create new user              |
                    | 3/ Find user                    |
                    | 4/ Remove user                  |
                    | 0/ Back to previous             |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
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
                    while (!passwordCheck.equals(userPassword)) {
                        System.out.println("password not right, re-enter your password");
                        passwordCheck = scanner.nextLine();
                    }
                    System.out.println("""
                            __________________________________
                            | Choose user role :              |
                            | 1/ SaleStaff                    |
                            | 2/ StoreKeeper                  |
                            | 3/ Accountant                   |
                            -----------------------------------------------------------------------------------------------
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
                    userManager.display();
                }
                case "3" -> System.out.println("Function is in develop, please comeback later~ Thank you!");
                case "4" -> userManager.remove();
                case "0" -> Menu.adminMenu();
            }
        }
        while (menuCondition);
    }

    public static void showUserListMenu() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Show all user                |
                    | 2/ Show accountant user         |
                    | 3/ Show Store Keeper user       |
                    | 4/ Show Sale Staff user         |
                    | 0/ Back to previous             |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> userManager.display();
                case "2", "3", "4" -> System.out.println("Function is in develop, please comeback later~ Thank you!");
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
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Show product                 |
                    | 2/ Create Receive Note          |
                    | 0/ Log out                      |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> Menu.showProductMenu();
                case "2" -> noteFactory.creatNote("ReceiveNote", currentUser);
                case "0" -> Menu.startMenu();
            }
        }
        while (menuCondition);
    }

    public static void accountantMenu() {
        menuCondition = true;
        do {
            Menu.drawHeader();
            System.out.println("""
                    __________________________________
                    | 1/ Show product                 |
                    | 2/ Show note list               |
                    | 3/ Business calculate           |
                    | 0/ Log out                      |
                    -----------------------------------------------------------------------------------------------
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> Menu.showProductMenu();
                case "2" -> Menu.showNoteList();
                case "3" -> businessCalculate.getBusinessResult();
                case "0" -> Menu.startMenu();
            }
        }
        while (menuCondition);
    }
}
