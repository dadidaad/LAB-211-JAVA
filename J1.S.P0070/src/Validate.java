
import java.util.regex.Pattern;

public class Validate {
    public boolean checkAccount(String account){
        Pattern p = Pattern.compile("^[0-9]{10}$");
        if(p.matcher(account).find()){
            return true;
        }
        return false;
    }
    public boolean checkPassword(String password){
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,31}$");
        if(p.matcher(password).find()){
            return true;
        }
        return false;
    }
    public boolean checkCaptcha(String captcha, String randCaptcha){
        for (int i = 0; i < captcha.length(); i++) {
            if(captcha.equals(randCaptcha)) return true;
            else if(randCaptcha.contains(captcha.substring(i, captcha.length()))){
                return true;
            }
        }
        return false;
    }
}
