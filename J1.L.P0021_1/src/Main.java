import java.util.*;
/**
 *
 * @author Vo Thanh Dat 
 */
public class Main {
    public static void main(String[] args) {
        StudentList t = new StudentList();
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("    1. Create");
        System.out.println("    2. Find and sort");
        System.out.println("    3. Update/Delete");
        System.out.println("    4. Report");
        System.out.println("    5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
        while(true){
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    t.create();
                    break;
                case 2:
                    t.FindAndSort();
                    break;
                case 3:
                    t.UpdateAndDelete();
                    break;
                case 4:
                    t.report();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong input!!");
            }
        }
    }

}
