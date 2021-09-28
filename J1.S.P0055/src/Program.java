
import java.util.*;

public class Program {

    public static Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("========= Doctor Management ==========\n"
                + "1.	Add Doctor\n"
                + "2.	Update Doctor\n"
                + "3.	Delete Doctor\n"
                + "4.	Search Doctor\n"
                + "5.	Exit");
        DoctorView dv = new DoctorView();
        int choice;
        while (true) {
            try {
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input!!");
                continue;
            }
            if (choice == 5) {
                break;
            }
            switch (choice) {
                case 1:
                    dv.listTest();
                    break;
                case 2:
                    dv.updateDoctor();
                    break;
                case 3:
                    dv.deleteDoctor();
                    break;
                case 4:
                    dv.searchDoctor();
                    break;
                default:
                    System.out.println("Don't have this choice!!");
                    break;
            }
        }
    }
}
