import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author Vo Thanh Dat 
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankManager bm = new BankManager();
        System.out.println("-------Login Program-------");
        while(true){
            try{
                System.out.println("1. Vietnamese\n" +"2. English\n" +"3. Exit");
                System.out.print("Please choice one option:");
                int choice = Integer.parseInt(sc.nextLine());
                if(choice == 3) break;
                switch(choice){
                    case 1:
                        Locale localeVi = new Locale("vi");
                        bm.setLocale(localeVi);
                        bm.login();
                        break;
                    case 2:
                        Locale localeEn = new Locale("en");
                        bm.setLocale(localeEn);
                        bm.login();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Don't have this option!");
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("Wrong format!");
                continue;
            }    
        }
    }

}
