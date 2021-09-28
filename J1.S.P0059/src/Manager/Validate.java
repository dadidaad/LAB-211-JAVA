package Manager;

import static Manager.Main.sc;

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
    public String enterPath(){
        String path;
        while(true){
            try{
                path = sc.nextLine().trim();
                if(checkString(path)) throw new MyException("Not empty!!");     
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return path;
    }
    
    
    public double enterMoney(){
        double money;
        while(true){
            try{
                System.out.print("Enter money: ");
                money = Double.parseDouble(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Wrong format!!");
                continue;
            }
            break;
        }
        return money;
    }
}
