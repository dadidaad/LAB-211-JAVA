package Manager;

import java.util.regex.Pattern;

public class Validate {
    public boolean checkSalary(String sSalary){
        try{
            double salary = Double.parseDouble(sSalary);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    public boolean checkInput(String str){
        Pattern p = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        if(p.matcher(str).find()){
            return true;
        }
        return false;
    }
}
