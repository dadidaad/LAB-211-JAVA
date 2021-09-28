package Manager;

import Enitty.Task;
import static Manager.Main.sc;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;

public class Validate {
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
    public String checkTaskType(){
        String taskType;
        while(true){
            try{
                taskType = sc.nextLine();
                int xTaskType = Integer.parseInt(taskType);
                if(xTaskType < 1 || xTaskType > 4) throw new MyException("Must be a digit from 1-4" + "\nTask Type:");
            }catch(NumberFormatException e){
                System.out.print("Must be a digit from 1-4" + "\nTask Type:");
                continue;
            }catch(MyException e){
                System.out.print(e.getMessage());
                continue;
            }
            break;
        }    
        return taskType;
    }
    public String checkDate(){
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
    public String checkPlan(){
        String plan;
        while(true){
            try{
                plan = sc.nextLine();
                if(!plan.matches("^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$")) throw new MyException("Must be format x.0 or x.5" + "\nRe-input: ");
                double xPlan = Double.parseDouble(plan);
                if(xPlan < 8.0 || xPlan > 17.5)    throw new MyException("Plan From To must be within 8 h-17 h 30" +"\nRe-input: ");
            }
            catch(MyException e){
                System.out.print(e.getMessage());
                continue;
            }
            catch(NumberFormatException e){
                System.out.print("Wrong format" +"\nRe-input: ");
                continue;
            }
            return plan;
        }
    }

    public boolean checkPlanFromTo(String planFrom, String planTo){
        double xPlanFrom = Double.parseDouble(planFrom);
        double xPlanTo = Double.parseDouble(planTo);
        if(xPlanFrom >= xPlanTo) {
            System.out.println("Plan From must be less than Plan To");
            return false;
        }
        return true;
    }
}
