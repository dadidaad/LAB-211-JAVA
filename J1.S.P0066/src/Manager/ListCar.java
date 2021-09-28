package Manager;
import java.util.*;
public class ListCar {
   HashMap<String, HashMap<String, String[]>> carList = new HashMap<>();

    public ListCar(){
       HashMap<String, String[]> CarDetail = new HashMap<>();
       String[] colorAudi = {"white", "yellow", "orange", "no color"};
       CarDetail.put("color",colorAudi);
       String[] priceAudi = {"5500", "3000", "4500"};
       CarDetail.put("price", priceAudi);
       String[] dayAudi = {"friday", "sunday", "monday"};
       CarDetail.put("day", dayAudi);
       HashMap<String, String[]> audi = new HashMap<>();
       audi.putAll(CarDetail);
       carList.put("AUDI", audi);
       CarDetail.clear();
       String[] colorMer = {"green", "blue", "purple", "no color"};
       CarDetail.put("color", colorMer);
       String[] priceMer = {"5000", "6000", "8500"};
       CarDetail.put("price", priceMer);
       String[] dayMer = {"tuesday", "saturday", "wednesday"};
       CarDetail.put("day", dayMer);
       HashMap<String, String[]> mer = new HashMap<>();
       mer.putAll(CarDetail);
       carList.put("MERCEDES", mer);
       CarDetail.clear();
       String[] colorBMW = {"pink", "red", "brown", "no color"};
       CarDetail.put("color", colorBMW);
       String[] priceBMW = {"2500", "3000", "3500"};
       CarDetail.put("price", priceBMW);
       String[] dayBMW = {"monday", "sunday", "thursday"};
       CarDetail.put("day", dayBMW);
       HashMap<String, String[]> BMW = new HashMap<>();
       BMW.putAll(CarDetail);
       carList.put("BMW", BMW);
       CarDetail.clear();
   }
    
    public boolean checkName(String name){
        Set<String> key = carList.keySet();
        for (String x : key) {
            if(name.equalsIgnoreCase(x)){
                return true;
            }
        }
        return false;
    }
    public boolean checkColor(String name, String color){
        Set<String> keyName = carList.keySet();
        for (String x : keyName) {
            if(name.equalsIgnoreCase(x)){
                HashMap<String, String[]> getColor = carList.get(x);
                String[] colorCar = getColor.get("color");
                for (String y : colorCar) {
                    if(color.equalsIgnoreCase(y)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkPrice(String name, double price, String color){
        Set<String> keyName = carList.keySet();
        for (String x : keyName) {
            if(name.equalsIgnoreCase(x)){
                HashMap<String, String[]> getPrice = carList.get(x);
                String[] priceCar = getPrice.get("price");
                for (String y : priceCar) {
                    double retail = Double.parseDouble(y);
                    if(color.equalsIgnoreCase("no color")){
                        retail -= 100;
                    }
                    if(price == retail){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkDay(String name, String day){
        Set<String> keyName = carList.keySet();
        for (String x : keyName) {
            if(name.equalsIgnoreCase(x)){
                HashMap<String, String[]> getDay = carList.get(x);
                String[] dayCar = getDay.get("day");
                for (String y : dayCar) {
                    if(day.equalsIgnoreCase(y)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
