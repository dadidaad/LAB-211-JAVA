import java.util.*;
/**
 *
 * @author Vo Thanh Dat 
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserSystem us = new UserSystem();
        System.out.println("====== USER MANAGEMENT SYSTEM ======\n" +
"1. Create a new account\n" +
"2. Login system\n" +
"3. Exit");
        while(true){
            System.out.print("> Choose: ");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice == 3) break;
            switch(choice){
                case 1:
                    us.createAccount();
                    System.out.println("Create account succesfully!");
                    break;
                case 2:
                    us.find();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invaild choice!");
                    break;
            }
        }
    }

}
