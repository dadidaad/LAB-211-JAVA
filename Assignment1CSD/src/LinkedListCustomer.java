

public class LinkedListCustomer {
    Node head, tail;
    public LinkedListCustomer() {
        head = tail = null;
    }
    public boolean isEmpty(){
        return head == null;
    }

    public Node getHead() {
        return head;
    }
    
    public void addLast(Customer x)
     {
        Node q = head;
        if(isEmpty()) {head=tail=q;return;}
        tail.next = q;
        tail = q;
     }
    public LinkedListCustomer(Node head, Node tail, Node node) {
        this.head = head;
        this.tail = tail;
    }
    public void visitCustomer(Node p){
        if(p != null){
            System.out.println(p.infoCustomer.toString());
        }
    }
   
    public void traverseCustomer(){
        Node p = head;
        while(p != null){
            visitCustomer(p);
            p = p.next;
        }
    }
    public Node searchByCcode(String xCode){
        if(isEmpty())   return null;
        Node q = head;
        while(q != null && !q.infoCustomer.ccode.equals(xCode)){
            q = q.next;
        }
        return q;
    }
    public void deleteByPcode(String xCode){
        if(isEmpty())   return;
        Node q = head;
        Node p = null;
        if(q != null && q.infoCustomer.ccode.equalsIgnoreCase(xCode)){
            q = head.next;
            return;
        }
        while(q != null && !q.infoCustomer.ccode.equalsIgnoreCase(xCode)){
            p = q;
            q = q.next;
        }
        if(q == null){
            return;
        }
        p.next = q.next;
    }

    

    
    
}
