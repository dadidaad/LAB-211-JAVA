import java.util.*;
/**
 *
 * @author Vo Thanh Dat 
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public int randomNumber(int n){
        Random value = new Random();
        int number = value.nextInt(n) + 1 ;
        return number;
    }
    public void inputArray(){
        int n;
        System.out.println("Enter number of array:");
        while(true){
            try{
                n = Integer.parseInt(sc.nextLine());
                if(n <= 0)  throw new Exception();
            }
            catch(InputMismatchException e1){
                continue;
            }
            catch(Exception e2){
                continue;
            }
            break;
        }   
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = randomNumber(n);
        }
        String array = Arrays.toString(arr);
        System.out.println("Unsorted array: " + array);
        bubbleSort(arr);
        array = Arrays.toString(arr);
        System.out.println("Sorted array: "+ array);
    }
    public void bubbleSort(int[] arr){
        int n = arr.length;
        boolean isSwapped;
        for(int i=0; i< n-1;i++){
            isSwapped = false;
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false){
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        m.inputArray();
        
    }

}
