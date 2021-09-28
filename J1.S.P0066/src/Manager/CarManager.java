package Manager;

import Entity.Car;
import java.util.*;
public class CarManager {
    ListCar lc = new ListCar();
    Validate vld = new Validate();
    public static Scanner sc = new Scanner(System.in);
    public Car inputCar(){
        Car x = new Car();
        while(true){
            try{
                System.out.print("Name: ");
                String name = sc.nextLine();
                if(!vld.checkInput(name)) throw new MyException("Invalid input!");
                System.out.print("Color: ");
                String color = sc.nextLine();
                if(!vld.checkInput(color)) throw new MyException("Invalid input!");
                System.out.print("Price: ");
                String sPrice = sc.nextLine();
                if(!vld.checkPrice(sPrice)) throw new MyException("Price is digit");
                double price = Double.parseDouble(sPrice); 
                if(price <= 0) throw new MyException("Price is greater than zero");
                System.out.print("Today: ");
                String day = sc.nextLine();
                if(!vld.checkInput(day)) throw new MyException("Invalid input!");
                x = new Car(name, color, price, day);
            }catch(MyException e ){
                System.out.println(e.getMessage());
                continue;
            }   
            break;
        }
        return x;
    }
    public void checkCar(){
        while(true){
            try{
                Car x = inputCar();
                if(!lc.checkName(x.getName())) throw new MyException("Can’t sell Car\n" +"Car break");
                if(!lc.checkColor(x.getName(), x.getColor())) throw new MyException("Can’t sell Car\n" + "Color Car does not exist");
                if(!lc.checkPrice(x.getName(), x.getPrice(), x.getColor())) throw new MyException("Can’t sell Car\n" + "Price Car does not exist");
                if(!lc.checkDay(x.getName(), x.getDay())) throw new MyException("Can’t sell Car\n" + "Car can't sell today");
            }catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("Sell car");
            System.out.print("Do you want find more?(Y/N):");
            char choice = sc.nextLine().toUpperCase().charAt(0);
            if(vld.checkY_N(choice)){
                if(choice == 'N') break;
            }
        }
    }
}
