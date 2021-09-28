package Manager;

import Entity.Employee;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeView {
    Validate vld = new Validate();
    EmployeeManager em = new EmployeeManager();
    Scanner sc = new Scanner(System.in);
    public void create(){
        while(true){
            System.out.print("Enter ID:");
            String id = vld.checkInputID();
            System.out.print("Enter first name:");
            String firstName = vld.checkInput();
            System.out.print("Enter last name:");
            String lastName = vld.checkInput();
            System.out.print("Enter Phone:");
            String phone = vld.checkPhoneInput();
            System.out.print("Enter email:");
            String email = vld.checkEmail();
            System.out.print("Enter address:");
            String address = vld.checkInput();
            System.out.print("Enter DOB:");
            String DOB = vld.checkDOB();
            System.out.print("Enter sex:");
            String sex = vld.checkSex();
            System.out.print("Enter salary:");
            double salary = vld.checkSalary();
            System.out.print("Enter egency:");
            String egency = vld.checkEgency();
            boolean check = em.add(id, firstName, lastName, phone, email, address, DOB, sex, salary, egency);
            if(check == false){
                System.out.println("Duplicate ID!!");
                continue;
            }
            System.out.println("Add successfull!");
            break;
        } 
    }
    public void update(){
        while(true){
            System.out.print("Enter id to update:");
            String id = vld.checkInputID();
            Employee x = em.checkID(id);
            if(x == null){
                System.out.println("Can not find ID in list");
                continue;
            }
            System.out.println("Update information");
            System.out.print("Enter first name:");
            String firstName = vld.checkInput();
            System.out.print("Enter last name:");
            String lastName = vld.checkInput();
            System.out.print("Enter Phone:");
            String phone = vld.checkPhoneInput();
            System.out.print("Enter email:");
            String email = vld.checkEmail();
            System.out.print("Enter address:");
            String address = vld.checkInput();
            System.out.print("Enter DOB:");
            String DOB = vld.checkDOB();
            System.out.print("Enter sex:");
            String sex = vld.checkSex();
            System.out.print("Enter salary:");
            double salary = vld.checkSalary();
            System.out.print("Enter egency:");
            String egency = vld.checkEgency();
            x = em.update(id, firstName, lastName, phone, email, address, DOB, sex, salary, egency);
            System.out.println("After update:");
            System.out.println(x.toString());
            break;
        }
    }
    public void remove(){
        String id;
        while(true){
            System.out.print("Enter ID to delete:");
            id = vld.checkInputID();
            if(em.checkID(id) == null){
                System.out.println("Can not find ID");
                continue;
            }
            break;
        }
        em.remove(id);
        System.out.println("After delete:");
        em.show();
    }
    public void search(){
        while(true){
            System.out.print("Enter name to search:");
            String name = sc.nextLine();
            ArrayList<Employee> list = em.searchbyName(name);
            if(list.size() == 0){
                System.out.println("Can not find any match name!");
                continue;
            }
            System.out.println("After search:");
            for (Employee x : list) {
                System.out.println(x.toString());
            }
            break;
        }
    }
    public void sort(){
        em.sortbySalary();
        System.out.println("Sort successfully");
        em.show();
    }
    public void menu(){
        while(true){
            System.out.println("Main menu:\n" +
                                "1.	Add employees \n" +
                                "2.	Update employees\n" +
                                "3.	Remove employees\n" +
                                "4.	Search employees\n" +
                                "5.	Sort employees by salary\n" +
                                "6.	Exit");
            System.out.print("Your choice:");
            int choice = vld.checkChoice();
            if(choice == 6) break;
            switch(choice){
                case 1:
                    create();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    search();
                    break;
                case 5:  
                    sort();
                    break;
                default:
                    break;
            }
        }
    }
}
