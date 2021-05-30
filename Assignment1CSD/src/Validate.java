public class Validate {
    public boolean checkExistPcode(LinkedListProduct t, String pcode){
        Node q = t.head;
        while(q != null){
            if(q.infoProduct.pcode.equalsIgnoreCase(pcode)){
                return true;
            }
            q = q.next;
        }
        return false;
    }
    public boolean checkExistCcode(LinkedListCustomer t, String ccode){
        Node q = t.head;
        while(q != null){
            if(q.infoCustomer.ccode.equals(ccode)){
                return true;
            }
            q = q.next;
        }
        return false;
    }
    public boolean checkInput(String str){
        if(str == null || str.equals("")){
            return true;
        }
        return false;
    }
    public boolean checkPhone(String str){
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean checkcodeinOrdering(LinkedListOrdering t, String pcode, String ccode){
        Node q = t.head;
        while(q != null){
            if(q.infoOrdering.pcode.equalsIgnoreCase(pcode) && q.infoOrdering.ccode.equalsIgnoreCase(ccode)){
                return true;
            }
            q = q.next;
        }
        return false;
    }
    public boolean checkQuantityinOrdering(LinkedListProduct t, String pcode, int qua){
        Node q = t.searchByPcode(pcode);
        if(q.infoProduct.saled == qua){
            return true;
        }
        return false;
    }
    public boolean checkQuantityInput(LinkedListProduct t, String pcode, int qua){
        Node q = t.searchByPcode(pcode);
        if(qua <= (q.infoProduct.quantity - q.infoProduct.saled)){
            return true;
        }
        return false;
    }
}
