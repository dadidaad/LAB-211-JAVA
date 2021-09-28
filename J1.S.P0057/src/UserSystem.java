import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserSystem {
    List<Account> t = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    Validate vld = new Validate();
    public void createAccount(){
        while(true){
            try{
                File data = new File("user.txt");
                if(!data.exists()){
                    data.createNewFile();
                }
                FileWriter fw = new FileWriter("user.txt");
                Account x = new Account();
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                if(!vld.checkUsername(username)) throw new MyException("You must enter least at 5 character, and no space!"); 
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                if(!vld.checkPassword(password)) throw new MyException("You must enter least at 6 character, and no space!");
                x = new Account(username, password);
                if(vld.checkExist(t, x)) throw new MyException("Username has been exist in data!");
                else{
                    t.add(x);
                    fw.write(x.toString());
                    fw.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getCause());
                continue;
            } catch (MyException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            break;
        }    
    }
    public void find(){
        Account x = new Account();
        while(true){
            try {
                File data = new File("user.txt");
                if(!data.exists()){
                    System.out.println("Can't find data");
                    return;
                }
                Scanner reader = new Scanner(data); 
                System.out.print("Enter Username: ");
                String xUser = sc.nextLine();
                if(!vld.checkUsername(xUser)) throw new MyException("You must enter least at 5 character, and no space!");
                System.out.print("Enter Password: ");
                String xPass = sc.nextLine();
                if(!vld.checkPassword(xPass)) throw new MyException("You must enter least at 6 character, and no space!");
                x = new Account(xUser, xPass);
                List<String> list = new ArrayList<>();
                while(reader.hasNextLine()){
                    String acc = reader.nextLine();
                    System.out.println(acc);
                    list.add(acc.trim());
                }
                Boolean check = false;
                for (String y : list) {
                    if(y.equalsIgnoreCase(x.toString())){
                        check = true;
                        break;
                    }
                }
                if(check == true){
                    System.out.println("Login succesfully");
                }
                else{
                    System.out.println("Invalid user name or password");
                    continue;
                }
            } catch (MyException ex) {
                System.out.println(ex.getMessage());
                continue;
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getCause());
                continue;
            }
        }
    }
}
