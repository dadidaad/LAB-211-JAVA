
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class FruitShop {
    ArrayList<Fruit> t = new ArrayList<>();
    Hashtable<String, ArrayList> ht = new Hashtable<String, ArrayList>();
    ArrayList<Order> fruitBuy = new ArrayList<>();
    Validate vld = new Validate();
    public void showList(){
        
        for (Fruit x : t) {
            System.out.println(x.toString());
        }
    }
    public boolean create(String xId, String xName, int xPrice, int xQuan, String xOrigin){
        Fruit x = new Fruit(xId, xName, xPrice, xQuan, xOrigin);
        if(vld.checkID(t, xId)){
            t.add(x);
            return true;
        }
        return false;
    }
    public void viewOrders(){
        if(ht.size() == 0)  System.out.println("No detail!");
        Set<String> Customer = ht.keySet();
        for(String x : Customer){
            System.out.println("Customer: "+ x);
            System.out.println("Product | Quantity | Price | Amount");
            ArrayList<Order> listOrder = ht.get(x);
            int index = 1;
            int total = 0;
            for (int i = 0; i < listOrder.size() ; i++) {
                System.out.println(index++ + listOrder.get(i).toString());
                total += listOrder.get(i).getAmount();
            }
            System.out.println("Total:"+total+"$");
        }
    }
    public void showShopping(){
        int count = 0;
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ |  ++ Price ++ |  ++ Quantity ++");
        for (Fruit x : t) {
            System.out.printf("%5d %10s %10s %3d %3d\n",++count, x.getFruitName(), x.getOrigin(), x.getPrice(), x.getQuan());
        }
    }
    public Fruit searchChoice(int choice){
        if(t == null){
            return null;
        }
        Fruit y = new Fruit();
        for (Fruit x : t) {
            if(choice == t.indexOf(x) + 1){
                y = x;
            }
        }
        return y;
    }
    public void addOrder(Fruit x, int xQuan){
        Order y = new Order();
        y = new Order(x.getFruitID(), x.getFruitName(), xQuan, x.getPrice());
        int index = t.indexOf(x);
        x.setQuan(x.getQuan() - xQuan);
        t.set(index, x);
        fruitBuy.add(y);
    }
    public int getTotalOrder(){
        int total=0;
        for (Order z : fruitBuy) {
            System.out.println(z.toString());
            total += z.getAmount();
        }
        return total;
    }
    public void shopping(String xName){
        ArrayList<Order> newList = new ArrayList<Order>();
        newList.addAll(fruitBuy);
        ht.put(xName, newList);
        fruitBuy.clear();
    }
}
