import java.util.Scanner;
public class Main {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minutes;
        System.out.print("Enter number of minutes : ");
        minutes = sc.nextInt();
        int hours= minutes / 60;
        int newminutes = minutes % 60;
        System.out.println("hours : " + hours);
        System.out.println("minutes : " + newminutes);
        System.out.print("Enter first name :");
        String first = sc.next();
        System.out.print("Enter middle name :");
        String middle = sc.next();
        System.out.print("Enter last name :");
        String last = sc.next();
        System.out.println("Hello "+ last + " " + middle + " "+ first );
        sc.close();
    }
    
}
