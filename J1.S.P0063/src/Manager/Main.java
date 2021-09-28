package Manager;
 import java.util.Scanner;

/**
 *
 * @author Vo Thanh Dat 
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        PersonList pl = new PersonList();
        System.out.println("=====Management Person programer=====");
        pl.inputPersoninfo();
        pl.sortByBubbleSort();
        pl.display();
    }

}
