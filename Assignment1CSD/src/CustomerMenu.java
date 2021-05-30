
import java.util.*;
import java.io.*;
public class CustomerMenu {
    LinkedListCustomer t = new LinkedListCustomer();
    public static Scanner sc = new Scanner(System.in);
    Validate vld = new Validate();
    public static String CustomerFile = "Customer.txt";
    public LinkedListCustomer getT() {
        return t;
    }
    
    public void loadDatafromFile() throws IOException{
        File file = new File(CustomerFile);
        if(!file.exists()){
            file.createNewFile();
        }
        while(true){
            try{
                Scanner read = new Scanner(file);
                if(!read.hasNextLine()){
                    System.out.println("File is empty");
                    read.close();
                    return;
                }
                FileReader fwRead = new FileReader(file);
                BufferedReader br = new BufferedReader(fwRead);
                String line = "";
                while((line = br.readLine()) != null){
                    String text = line.replaceAll("//s+", "");
                    String[] info = text.trim().split("[|]");
                    String ccode = info[0].trim();
                    String cus_name = info[1].trim();
                    String phone = info[2].trim();
                    if(vld.checkExistCcode(t, ccode) || vld.checkPhone(phone)){
                        continue;
                    }
                    else{
                        Customer x = new Customer(ccode, cus_name, phone);
                        t.addLast(x);
                    }
                    
                }
                read.close();
                br.close();
                fwRead.close();
            }catch(FileNotFoundException e){
                continue;
            } catch (IOException e) {  
                continue;
            }
            System.out.println("Load succesfully!");
            break;
        }
    }
    public void input_add(){
        while(true){
            try{
                System.out.print("Enter ccode: ");
                String ccode = sc.nextLine();
                if(vld.checkExistCcode(t, ccode) || vld.checkInput(ccode)) throw new Myexception("Blank input or code has been exist in list");
                System.out.print("Enter cus name: ");
                String cus_name = sc.nextLine();
                if(vld.checkInput(ccode)) throw new Myexception("Blank input!! Try again");
                System.out.print("Enter phone: ");
                String phone = sc.nextLine();
                if(vld.checkPhone(phone)) throw new Myexception("Phone must contain digit only!");
                Customer x = new Customer(ccode, cus_name, phone);
                t.addLast(x);
            }
            catch(Myexception e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("Add succesfully!");
            break;
        }
    }
    public void display_data(){
        System.out.println("Ccode |   Cus_name  |  Phone");
        t.traverseCustomer();
    }
    public void saveListtoFile() throws FileNotFoundException, IOException{
        File text = new File(CustomerFile);
        if(!text.exists()){
            text.createNewFile();
        }
        PrintWriter pw = new PrintWriter(text);
        pw.write("");
        pw.close();
        FileWriter fw = new FileWriter(text);
        Node p = t.head;
        while(p != null){
            fw.write(p.infoCustomer.toString()+ "\n");
            p = p.next;
        }
        fw.close();
        System.out.println("Save successfully!");
    }
    public void searchByCcode(){
        if(t.isEmpty()){
            System.out.println("List is emtpy");
            return;
        }
        while(true){
            try{
                System.out.print("Enter Cus code: ");
                String xCcode = sc.nextLine();
                if(vld.checkInput(xCcode)) throw new Myexception("Blank input!!");
                else if(!vld.checkExistCcode(t, xCcode))    throw new Myexception("Can not found Ccode");
                else{
                    System.out.println("Ccode you find: ");
                    System.out.println("Ccode |   Cus_name  |  Phone");
                    Node q = t.searchByCcode(xCcode);
                    t.visitCustomer(q);
                }
            }
            catch(Myexception e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }
    public void deleteByCcode(){
        if(t.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        while(true){
            try{
                System.out.print("Enter Cus code: ");
                String xCcode = sc.nextLine();
                if(vld.checkInput(xCcode)) throw new Myexception("Blank input!!");
                else if(!vld.checkExistCcode(t, xCcode))    throw new Myexception("Can not found Ccode");
                else{
                    t.deleteByPcode(xCcode);
                }
            }
            catch(Myexception e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("Delete Succesfully!");
            break;
        }
    }
}   
