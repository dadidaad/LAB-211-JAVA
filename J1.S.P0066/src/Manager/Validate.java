package Manager;

import java.util.regex.Pattern;

public class Validate {
    public boolean checkPrice(String sPrice){
        try{
            double price = Double.parseDouble(sPrice);
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
    public boolean checkY_N(char choice){
        if(choice == 'Y' || choice == 'N'){
            return true;
        }
        return false;
    }
}
