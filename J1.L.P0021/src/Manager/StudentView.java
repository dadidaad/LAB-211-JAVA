package Manager;

import java.util.ArrayList;
import Entity.Student;
import java.util.Scanner;

public class StudentView {
    Validate vld = new Validate();
    StudentManager sm = new StudentManager();
    Scanner sc = new Scanner(System.in);
    public void create(){
        while(true){
            System.out.print("Enter student ID: ");
            String id = vld.inputID();
            System.out.print("Enter student name: ");
            String name = vld.inputName();
            System.out.print("Enter semester: ");
            int semester = vld.inputSemester();
            System.out.print("Enter course name(Java, .Net, C/C++): ");
            String courseName = vld.inputCourse();
            int n = sm.create(id, name, semester, courseName);
            if(n == -1){
                System.out.println("Add fail");
                continue;
            }
            if(n > 9){
                System.out.print("Do you want to continue (Y/N)? : ");
                char choice = vld.checkChoice();
                if(choice == 'Y'){
                    continue;
                }
                else{
                    sm.displayList();
                    break;
                }
            }
        }
    }
    public void findAndSort(){
        System.out.print("Enter name to find: ");
        String name = sc.nextLine();
        ArrayList<Student> list = sm.findAndSort(name);
        if(list == null){
            System.out.println("List student is empty or don't have name in list");
        }
        System.out.println("List student find:");
        for (Student x : list) {
            System.out.println(x.toString());
        }
    }
    public void updateOrDelete(){
        System.out.print("Enter id to find: ");
        String id = sc.nextLine();
        Student x = sm.searchByID(id);
        if(x == null){
            System.out.println("Can not find ID student in list");
        }
        System.out.println(x.toString());
        System.out.print("Do you want to update (U) or delete (D) student: ");
        char choice =  vld.checkChoiceUD();
        if(choice == 'U'){
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter semester: ");
            int semester = Integer.parseInt(sc.nextLine());
            System.out.print("Enter course name(Java, .Net, C/C++): ");
            String courseName = sc.nextLine();
            x = sm.update(id, name, semester, courseName);
            if(x == null){
                System.out.println("Edit data duplicate with data in list");
            }
            System.out.println("After update:");
            System.out.println(x.toString());
        }
        if(choice == 'D'){
            sm.delete(id);
            System.out.println("Delete successfully");
            sm.displayList();
        }
    }
    public void report(){
       System.out.println("Report of student:");
       sm.report();
    }
    public void menu(){
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("    1. Create");
        System.out.println("    2. Find and sort");
        System.out.println("    3. Update/Delete");
        System.out.println("    4. Report");
        System.out.println("    5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
        while(true){
            System.out.print("Your choice: ");
            int choice = vld.checkInputLimit();
            if(choice == 5) break;
            switch(choice){
                case 1:
                    create();
                    break;
                case 2:
                    findAndSort();
                    break;
                case 3:
                    updateOrDelete();
                    break;
                case 4:
                    report();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong input!!");
            }
        }
    }
}
