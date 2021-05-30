
import java.util.*;
public class OrderingMenu {
    LinkedListOrdering to = new LinkedListOrdering();
    CustomerMenu y = new CustomerMenu();
    ProductMenu x = new ProductMenu();
    Validate vld = new Validate();
    OrderingMenu(ProductMenu x, CustomerMenu y){
        this.x = x;
        this.y = y;
    }
    public static Scanner sc = new Scanner(System.in);
    public void input_data(){
        LinkedListCustomer tc = y.getT();
        LinkedListProduct tp =  x.getT();
        if(tc.isEmpty() || tp.isEmpty()){
            System.out.println("Product list or Customer list is empty");
            return;
        }
        while(true){
            try{
                System.out.print("Enter pcode: ");
                String pcode = sc.nextLine();
                if(!vld.checkExistPcode(tp, pcode)) throw new Myexception("Can not found pcode in Product list");
                System.out.print("Enter ccode: ");
                String ccode = sc.nextLine();
                if(!vld.checkExistCcode(tc, ccode)) throw new Myexception("Can not found ccode in Customer list");
                if(vld.checkcodeinOrdering(to, pcode, ccode)) throw new Myexception("Both pcode and ccode are found in the order list!");
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(sc.nextLine());
                if(vld.checkQuantityinOrdering(tp, pcode, quantity)) throw new Myexception("the product is  exhausted.");
                if(!vld.checkQuantityInput(tp, pcode, quantity)) throw new Myexception("Quantity is over!");
                Ordering x = new Ordering(pcode, ccode, quantity);
                to.addLast(x);
            }
            catch(Myexception e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("Add successfully");
            break;
        }
    }
    public void displayOrderingData(){
        System.out.println("Pcode   |   Ccode   |   Quantity");
        to.traverseOrdering();
    }
    public void sortbyPcode_Ccode(){
        to.sortByPcodeCcode();
    }
}
