
import java.util.*;
public class BankManager {
    Validate vld = new Validate();
    Scanner sc = new Scanner(System.in);
    Locale locale;
    String account;
    String password;
    String captcha;
    public void setLocale(Locale locale){
        this.locale = locale;
    }
    public String getWord(String word){
        ResourceBundle labels = ResourceBundle.getBundle(this.locale + "", this.locale);
        return labels.getString(word);
    }
    
    public String checkAccountNumber(String account){
        while(true){
            try{
                System.out.print(getWord("Account number")+": ");
                account = sc.nextLine();
                if(!vld.checkAccount(account)) throw new MyException(getWord("Account number must is a number and must have 10 digits"));
                else{
                    break;
                }
            }catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
        return account;
    }
    public String checkPassword(String password){
        while(true){
            try{
                System.out.print(getWord("Password")+": ");
                password = sc.nextLine();
                if(!vld.checkPassword(password))throw new MyException(getWord("Password must be between 8 and 31 characters and must be alphanumeric"));
                else{
                    break;
                }
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
        return password;
    }
    public String generateCaptcha(){
        StringBuilder captcha = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        while(captcha.length() < 5){
            int rand = random.nextInt(chars.length());
            captcha.append(chars.charAt(rand));
        }
        return captcha.toString();
    } 
    public String checkCaptcha(String inputCaptcha, String randCaptcha){
        System.out.println("Captcha: "+randCaptcha);
        while(true){
            int i=0;
            try{
                System.out.print(getWord("Enter a Captcha incorrect characters")+": ");
                inputCaptcha = sc.nextLine();
                if(!vld.checkCaptcha(inputCaptcha, randCaptcha)) throw new MyException(getWord("Captcha incorrect"));
                else{
                    break;
                }
            }
            catch(MyException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
        return inputCaptcha;
    }
    
    
    void login(){
        checkAccountNumber(account);
        checkPassword(password);
        checkCaptcha(captcha, generateCaptcha());
    }
}
