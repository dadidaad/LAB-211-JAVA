package Manager;

import Entity.Person;
import static Manager.Main.sc;

public class PersonList {
    Validate vld = new Validate();
    Person[] arrPerson = new Person[10];
    public void inputPersoninfo(){
        int count = 0;
        while(count < 3){
            Person x = new Person();
            try{
                System.out.println("Input Information of Person");
                System.out.print("Please input name:");
                String name = sc.nextLine();
                if(!vld.checkInput(name)) throw new MyException("Invalid name!");
                System.out.print("Please input address:");
                String address = sc.nextLine();
                if(!vld.checkInput(address)) throw new MyException("Invalid address");
                System.out.print("Please input salary:");
                String sSalary = sc.nextLine();
                double salary = 0;
                if(!vld.checkSalary(sSalary)){
                    System.out.println("You must input digit");
                    System.out.print("Please input salary:");
                    sSalary = sc.nextLine();
                    salary = Double.parseDouble(sSalary);
                    if(salary <= 0){
                        System.out.println("Salary is greater than zero");
                        System.out.print("Please input salary:");
                        sSalary = sc.nextLine();
                    }
                }
                salary = Double.parseDouble(sSalary);
                x = new Person(name, address, salary);
                arrPerson[count++] = x;
            }catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
    public void display(){
        for (int i = 0; i < 3; i++) {
            System.out.println("Information of Person you have entered:");
            System.out.println("Name:"+arrPerson[i].getName());
            System.out.println("Address:"+arrPerson[i].getAddress());
            System.out.println("Salary:"+arrPerson[i].getSalary());
            System.out.println();
        }
    }
    public void sortByBubbleSort(){
        try{
            Boolean isSwapped;
            for (int i = 0; i < 2; i++) {
                isSwapped = false;
                for (int j = 0; j < 2 - i; j++) {
                    if(arrPerson[j].getSalary() > arrPerson[j+1].getSalary()){
                        Person temp = arrPerson[j];
                        arrPerson[j] = arrPerson[j+1];
                        arrPerson[j+1] = temp;
                        isSwapped = true;
                    }
                }
                if(isSwapped == false){
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println("Can't sort Person");
        }
    }
}
