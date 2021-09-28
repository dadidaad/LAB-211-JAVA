
import java.util.List;
import java.util.regex.Pattern;

public class Validate {
    public boolean checkExist(List<Account> t, Account x){
        if(t.contains(x)){
            return true;
        }
        return false;
    }
    public boolean checkUsername(String user){
        Pattern p = Pattern.compile("^[a-zA-Z0-9]{5,}$");
        if(p.matcher(user).find()){
            return true;
        }
        return false;
    }
    public boolean checkPassword(String pass){
        Pattern p = Pattern.compile("^[a-zA-Z0-9@#$%^&+=]{6,}$");
        if(p.matcher(pass).find()){
            return true;
        }
        return false;
    }
}
