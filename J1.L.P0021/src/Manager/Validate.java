package Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    Scanner sc = new Scanner(System.in);
    public String inputName(){
        String name;
        while(true){
            name = sc.nextLine();
            Pattern p = Pattern.compile("^(([A-Za-z]+[ ]?|[a-z]+)+)$");
            if(!p.matcher(name).find()){
                System.out.print("Invalid!!" +"\nRe-input:");
                continue;
            }
            break;
        }
        name = name.trim().toLowerCase();
        name = name.replaceAll("//s+", " ");
        String[] temp = name.split(" ");
        name = "";
        for (int i = 0; i < temp.length; i++) {
            name += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i < temp.length - 1) name += " ";
            
        }
        return name;
    }
    public String inputID(){
        String id;
        while(true){
            id = sc.nextLine();
            Pattern p = Pattern.compile("^SV{1}[0-9]+$");
            if(!p.matcher(id).find()){
                System.out.print("Invalid!! Re-input: ");
                continue;
            }
            break;
        }
        return id;
    }
    public int inputSemester(){
        int semester;
        while(true){
            try{
                String xSemester = sc.nextLine();
                semester = Integer.parseInt(xSemester);
            }
            catch(NumberFormatException e){
                System.out.print("Invalid!! Re-input: ");
                continue;
            }
            break;
        }
        return semester;
    }
    public String inputCourse(){
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add(".net");
        list.add("c/c++");
        String course;
        while(true){
            course = sc.nextLine();
            course = course.toLowerCase();
            if(!list.contains(course)){
                System.out.print("Don't have course!! Re-input: ");
                continue;
            }
            break;
        }
        return course;
    }
    public char checkChoice(){
        String choice;
        while(true){
            choice = sc.nextLine().toUpperCase().trim();
            if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")){
                break;
            }
        }
        return choice.charAt(0);
    }
    public char checkChoiceUD(){
        String choice;
        while(true){
            choice = sc.nextLine().toUpperCase().trim();
            if(choice.equalsIgnoreCase("U") || choice.equalsIgnoreCase("D")){
                break;
            }
        }
        return choice.charAt(0);
    }
    public int checkInputLimit(){
        int choice;
        while(true){
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice < 1 || choice > 5){
                    continue;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Wrong format!");
                continue;
            }
            break;
        }
        return choice;
    }
}
