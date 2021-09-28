public class Account {
    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public boolean equals(Object o){
        if(o == null)   return false;
        if(o instanceof Account){
            Account x = (Account)o;
            return x.username.equals(this.username);
        }
        return false;
    }

    @Override
    public String toString() {
        return username + " " + password;
    }
    
}
