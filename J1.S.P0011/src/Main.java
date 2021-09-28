import java.math.BigInteger;
import java.util.*;
/**
 *
 * @author Vo Thanh Dat 
 */
public class Main {
    public static Scanner sc = new Scanner (System.in);
    
    public int digitToValue(char c){
        if(c >= '0' && c <= '9'){
            return (int)c - '0';
        }
        else 
            return (int)c - 'A' + 10;
    }
    public BigInteger fromBasetoDec(String str, int base1){
        if (base1 < 2 || (base1 > 10 && base1 != 16))
            return null;
        BigInteger value = new BigInteger("0", 10);
        BigInteger power = new BigInteger("1", 10);
        for (int i = str.length() - 1; i >= 0; i--) {
            int digit = digitToValue(str.charAt(i));
            if(digit < 0 || digit >= base1){
                return null;
            }
            BigInteger multi = power.multiply(BigInteger.valueOf(Integer.valueOf(digit)));
            value = value.add(multi);
            power = power.multiply(BigInteger.valueOf(Integer.valueOf(base1)));
        }
        return value;
    }
    public String fromDectoBase(BigInteger number, int base2){
        StringBuilder result = new StringBuilder();
        if(number.equals(BigInteger.valueOf(Integer.valueOf(0)))) return "0";
        while(number.compareTo(BigInteger.valueOf(Integer.valueOf(0))) != 0){
            BigInteger reminder = number.mod(BigInteger.valueOf(Integer.valueOf(base2)));
            if(base2 == 16){
                if(reminder.equals(BigInteger.valueOf(Integer.valueOf(10)))){
                    result.insert(0,"A");
                }
                else if(reminder.equals(BigInteger.valueOf(Integer.valueOf(11)))){
                    result.insert(0, "B");
                }else if(reminder.equals(BigInteger.valueOf(Integer.valueOf(12)))){
                    result.insert(0, "C");
                }else if(reminder.equals(BigInteger.valueOf(Integer.valueOf(13)))){
                    result.insert(0, "D");
                }else if(reminder.equals(BigInteger.valueOf(Integer.valueOf(14)))){
                    result.insert(0, "E");
                }else if(reminder.equals(BigInteger.valueOf(Integer.valueOf(15)))){
                    result.insert(0, "F");
                }
                else{
                    result.insert(0, String.valueOf(reminder));
                }
            }
            else{
                result.insert(0, String.valueOf(reminder));
            }
            number = number.divide(BigInteger.valueOf(Integer.valueOf(base2)));
        }
        return result.toString();
    }
    public String baseToBase(String str, int base1, int base2){
        BigInteger number = fromBasetoDec(str, base1);
        String result = fromDectoBase(number, base2);
        return result;
    }
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Choose the base number input: \n1.Binary\n2.Decimal\n3.Hexadecimal");
        int input1 = Integer.parseInt(sc.nextLine());
        System.out.println("Choose the base number output: \n1.Binary\n2.Decimal\n3.Hexadecimal");
        int input2 = Integer.parseInt(sc.nextLine());
        int base1=0,base2=0;
        switch (input1) {
            case 1:
                base1 = 2;
                break;
            case 2:
                base1 = 10;
                break;
            case 3:
                base1 = 16;
                break;
            default:
                break;
        }
        switch (input2) {
            case 1:
                base2 = 2;
                break;
            case 2:
                base2 = 10;
                break;
            case 3:
                base2 = 16;
                break;
            default:
                break;
        }
        System.out.println("Enter number to convert: ");
        String str = sc.nextLine();
        System.out.println("After convert the result is " + m.baseToBase(str, base1, base2));
        
    }

}
