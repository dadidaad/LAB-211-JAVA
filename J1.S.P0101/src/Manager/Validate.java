package Manager;

import Entity.Employee;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    Scanner sc = new Scanner(System.in);
    public int checkChoice(){
        int choice;
        while(true){
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice < 1 || choice > 6) throw new MyException("Don't have this option!");
            }
            catch(NumberFormatException e){
                System.out.println("Wrong format!");
                continue;
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return choice;
    }
    public String checkInputID(){
        String str;
        while(true){
            str = sc.nextLine();
            Pattern p = Pattern.compile("^(([A-Za-z0-9]+|[a-z0-9])+)$");
            if(!p.matcher(str).find()){
                System.out.print("Invalid!!" +"\nRe-input:");
                continue;
            }
            break;
        }
        return str;
    }
    public String checkInput(){
        String str;
        while(true){
            str = sc.nextLine();
            Pattern p = Pattern.compile("^(([A-Za-z]+[,.]?[ ]?|[a-z]+['-]?)+)$");
            if(!p.matcher(str).find()){
                System.out.print("Invalid!!" +"\nRe-input:");
                continue;
            }
            break;
        }
        return str;
    }
    public String checkPhoneInput(){
        String str;
        while(true){
            try{
                str = sc.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    if(!Character.isDigit(str.charAt(i))) throw new MyException("Must be digit only");
                }
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return str;
    }
    public String checkEmail(){
        String str;
        while(true){
            str = sc.nextLine();
            Pattern p = Pattern.compile("^[A-Z0-9]+@[A-Z0-9]+\\.[A-Z]{1,}$", Pattern.CASE_INSENSITIVE);
            if(!p.matcher(str).find()){
                System.out.print("Invalid!!" +"\nRe-input:");
                continue;
            }
            break;
        }
        return str;
    }
    public String checkDOB(){
        String dateStr = "";
        while(true){
        try{
            dateStr = sc.nextLine();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(dateStr, format);
        }
        catch(DateTimeParseException e){
            System.out.print("Must be format dd-MM-yyyy" + "\nDate: ");
            continue;
        }
        break;
        }
        return dateStr;
    }
    public String checkSex(){
        String sex;
        while(true){
            sex = sc.nextLine().trim();
            if(!sex.matches("^(([A-Za-z0-9]+[,.]?[ ]?|[a-z]+['-]?)+)$")){
                System.out.println("Invalid");
                continue;
            }
            if(sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female") || sex.equalsIgnoreCase("3rd sex")){
                break;
            }
            System.out.print("Male or Female or 3rd sex: ");
        }
        return sex;
    }
    public double checkSalary(){
        double salary;
        while(true){
            try{
                String xSalary = sc.nextLine();
                salary = Double.parseDouble(xSalary);
                if(salary <= 0) throw new MyException("Must greater than 0");
            }
            catch(NumberFormatException e){
                System.out.println("Wrong format");
                continue;
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return salary;
    }
    public String checkEgency(){
        String choice;
        while(true){
            choice = sc.nextLine().toUpperCase().trim();
            if(!choice.matches("^(([A-Za-z]+[,.]?[ ]?|[a-z]+['-]?)+)$")){
                System.out.println("Invalid!!");
                continue;
            }
            if(choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("No")){
                break;
            }
            System.out.print("Yes/No only:");
        }
        return choice;
    }
}
