
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    public Scanner sc = new Scanner(System.in);
    public String checkInput(){
        String str;
        while(true){
            str = sc.nextLine();
            Pattern p = Pattern.compile("^(([A-Za-z0-9]+[ ]?|[a-z]+['-]?)+)$");
            if(!p.matcher(str).find()){
                System.out.print("Invalid!!" +"\nRe-input:");
                continue;
            }
            break;
        }
        return str;
    }
    public boolean checkID(ArrayList<Fruit> list, String ID){
        for (Fruit x : list) {
            String fruitID = x.getFruitID();
            if(fruitID.equalsIgnoreCase(ID)){
                return false;
            }
        }
        return true;
    }
    public int checkInt(){
        int number;
        while(true){
            try{
                number = Integer.parseInt(sc.nextLine());
                if(number <= 0) throw new MyException("Must > 0");
            }
            catch(NumberFormatException e){
                System.out.println("Digit only!!");
                continue;
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }break;
        }
        return number;
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
    
}
