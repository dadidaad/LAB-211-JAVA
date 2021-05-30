
import java.util.*;

class LinkedListOrdering {
    Node head, tail;

    public LinkedListOrdering() {
        head = tail = null;
    }
    public boolean isEmpty(){
        return head == null;
    }     
    public void remove(Node q)
     {
         Node temp = head;
         Node prev = null;
         if(temp != null && temp == q){
             head =  temp.next;
             return;
         }
         while(temp != null && temp != q){
             prev = temp;
             temp = temp.next;
         }
         if(temp == null){
             return;
         }
         prev.next = temp.next;
     }
    public void clear(){
        Node q = head;
        while(true){
            if(q == null)   break;
            remove(q);
        }
    }
    public void addLast(Ordering x)
     {Node q = new Node(x);
       if(isEmpty()) {head=tail=q;return;}
       tail.next = q;
       tail = q;
     }
    public void visitOrdering(Node p){
        if(p != null){
            System.out.println(p.infoOrdering.toString());
        }
    }
   
    public void traverseOrdering(){
        Node p = head;
        while(p != null){
            visitOrdering(p);
            p = p.next;
        }
    }
    public double totalValue(double x, Node p){
        return x * p.infoOrdering.quantity;
    }
    int size()
     {
         Node q = head;
         int i=0;
         while(q != null){
             q=q.next;
             i++;
         }
         return(i);
     }
    Ordering [] toArray()
     {
         int n = size();
         int i=0;
         Ordering[] a = new Ordering[n];
         Node p = head;
         while(p != null){
          a[i++] = new Ordering(p.infoOrdering.pcode, p.infoOrdering.ccode, p.infoOrdering.quantity);
          p=p.next;
        }
         return(a);
     }
    public void sortByPcodeCcode(){
        Ordering[] arr = toArray();
        Arrays.sort(arr, (Ordering o1, Ordering o2) -> o1.pcode.compareTo(o2.pcode));
        clear();
        for(int i=0; i<arr.length; i++){
            addLast(arr[i]);
        }
        System.out.println("Sort by pcode:");
        System.out.println("Pcode   |   Ccode   |   Quantity");
        traverseOrdering();
        Arrays.sort(arr, (Ordering o1, Ordering o2) -> o1.ccode.compareTo(o2.ccode));
        clear();
        for(int i=0; i<arr.length; i++){
            addLast(arr[i]);
        }
        System.out.println("Sort by ccode:");
        System.out.println("Pcode   |   Ccode   |   Quantity");
        traverseOrdering();
    }
    
}
