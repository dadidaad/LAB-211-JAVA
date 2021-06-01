package Manager;

public class Validate {
    
    public boolean checkString(String str){
        if(str.isEmpty()){
            return true;
        }
        return false;
    }
    
    
    public boolean isDouble(String doublestr){
        try{
           double x = Double.parseDouble(doublestr);
           
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
