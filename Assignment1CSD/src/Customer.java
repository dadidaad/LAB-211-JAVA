


public class Customer {
    String ccode;
    String cus_name;
    String phone;

    public Customer() {
    }

    public Customer(String ccode, String cus_name, String phone) {
        this.ccode = ccode.toUpperCase();
        this.cus_name = cus_name.substring(0, 1).toUpperCase() + cus_name.substring(1).toLowerCase();
        this.phone = phone;
    }
    @Override
    public boolean equals(Object o){
        if(o == null)   return false;
        if(o instanceof Customer){
            Customer x = (Customer)o;
            return x.ccode.equalsIgnoreCase(this.ccode);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s   |   %-7s   |  %4s", ccode, cus_name, phone);
    }
    
}
