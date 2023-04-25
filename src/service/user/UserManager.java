package service.user;

import io.ReadMapData;
import io.WriteMapData;
import model.user.Admin;
import model.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class UserManager implements IUserManager {
//    private static final UserManager userManager = new UserManager();
    private static Map<String, User > userList = new HashMap<>();
    WriteMapData<String,User> saver = new WriteMapData<>();
    private final static ReadMapData<String, User> loader = new ReadMapData<>();


    public void saveUser(){
        String path = "src/io/database/user_save.txt";
        saver.writeToSaveFile(userList,path);
    }
    public static void loadUser(){
        String path = "src/io/database/user_save.txt";
        userList = loader.loadMapData(path);
        userList.put("admin", Admin.getAdmin());
        System.out.println("User loaded!");
    }
    public UserManager() {
    }

    public static Map<String,User> getUserList(){
        return userList;
    }
    public boolean isUserExisted(String userName){
        return userList.containsKey(userName);
    }

    @Override
    public void add(User user) {
        if(!isUserExisted(user.getUserName())) {
            userList.put(user.getUserName(), user);
        }
        else {
            System.out.println("This user name is already existed!");
        }
        saveUser();
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user name that you want to remove");
        String userName = scanner.nextLine();
        if(isUserExisted(userName)){
            System.out.println("Are you sure to delete this user? " + userName);
            System.out.println("""
                    1/ Confirm
                    0/ Cancel
                    """);
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                userList.remove(userName);
                saveUser();
                System.out.println("User deleted");
            } else {
                System.out.println("Canceled");
            }
        }
        else {
            System.out.println("User not found!");
        }
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user name that you want to edit");
        String userName = scanner.nextLine();
        if(isUserExisted(userName)){
            System.out.println("Enter the new Full Name");
            String fullName = scanner.nextLine();
            System.out.println("Enter the new Phone Number");
            String phoneNumber = scanner.nextLine();
            userList.get(userName).setUserFullName(fullName);
            userList.get(userName).setPhoneNumber(phoneNumber);
            saveUser();
        }
        else {
            System.out.println("User not found!");
        }
    }


    @Override
    public void display() {
       for(Map.Entry<String,User> entry : userList.entrySet()){
           if(!entry.getKey().equals("admin")){
               System.out.println("UserName: " + entry.getValue().getUserName() +
                       ",User Full Name : " + entry.getValue().getUserFullName() +
                       ",User Phone Number : " + entry.getValue().getPhoneNumber() +
                       ", User Role: " + entry.getValue().getRole());
           }
       }
    }
}
