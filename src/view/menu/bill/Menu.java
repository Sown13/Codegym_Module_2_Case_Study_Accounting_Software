//package view.menu.bill;
//
//import java.util.Scanner;
//
//public class Menu {
//    static Scanner scanner = new Scanner(System.in);
////    public static void mainMenu(){
////        do {
////            System.out.println("""
////                    1/
////                    """);
////        }
////        while (true);
////    }
//
//    public static void LoginMenu(){
//        do {
//            System.out.println("""
//                    1/ Login
//                    2/ Sign Up
//                    0/ Cancel
//                    """);
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice){
//                case 1 -> {
//                    System.out.println("Enter the User Name");
//                    String userName = scanner.nextLine();
//                    System.out.println("Enter the Password");
//                    String userPassword = scanner.nextLine();
//                    @// TODO: 4/22/2023   // Need to provoke a method for login
//                }
//                case 2 -> {
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
//                    @// TODO: 4/22/2023 // Need to method to create new user
//                }
//                case 0 -> System.exit(0);
//            }
//        }
//        while (true);
//    }
//
//    public static void StoreKeeperMenu(){
//        do {
//            System.out.println("""
//                    1/ Show inventory
//                    2/ Find product
//                    3/ Create [Goods Delivery Note]
//                    4/ Create [Goods Receive Note]
//                    5/ Log out
//                    0/ Close Program
//                    """);
//            int choice = Integer.parseInt(scanner.nextLine());
//
//        }
//        while (true)
//    }
//
//    public static void AccountantMenu(){
//
//    }
//}
