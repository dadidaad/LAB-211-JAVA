
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixMenu {
    Matrix matrix = new Matrix();
    Scanner sc = new Scanner(System.in);
    int choice;
    public List<int[][]> inputmatrix(){
        int m,n,a,b;
        List<int[][]> list = new ArrayList<>();
        while(true){
            try{
                System.out.print("Enter row matrix 1:");
                n = Integer.parseInt(sc.nextLine());
                System.out.print("Enter column matrix 1:");
                m = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Must be digit");
                continue;
            }
            break;
        }
        int row=1, col=1;
        int[][] matrix1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            col=1;
            for(int j = 0; j < m; j++){
                while(true){
                    try{
                        System.out.print("Enter matrix1["+ row + "]" + "[" + col +"]:" );
                        matrix1[i][j] = Integer.parseInt(sc.nextLine());
                    }catch(NumberFormatException e){
                        System.out.println("value of matrix is digit");
                        continue;
                    }break;
                }
                col++;
            }
            row++;
        }
        list.add(matrix1);
        while(true){
            try{
                System.out.print("Enter row matrix 2:");
                a = Integer.parseInt(sc.nextLine());
                System.out.print("Enter column matrix 2:");
                b = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Must be digit");
                continue;
            }
            break;
        }
        row=1;col=1;
        int[][] matrix2 = new int[a][b];
        for (int i = 0; i < a; i++) {
            col=1;
            for(int j = 0; j < b; j++){
                while(true){
                    try{
                        System.out.print("Enter matrix2["+ row + "]" + "[" + col +"]:" );
                        matrix2[i][j] = Integer.parseInt(sc.nextLine());
                    }catch(NumberFormatException e){
                        System.out.println("value of matrix is digit");
                        continue;
                    } 
                    break;
                }
                col++;
            }
            row++;
        }
        list.add(matrix2);
        return list;
    }
    public void result(){
        List<int[][]> list = inputmatrix();
        char[] operator = {'+', '-', '*'};
        int[][] matrix1 = list.get(0);
        int[][] matrix2 = list.get(1);
        System.out.println("--------Result---------");
        displaymatrix(matrix1);
        System.out.println(operator[choice - 1]);
        displaymatrix(matrix2);
        System.out.println("=");
        switch(choice){
            case 1:
                displaymatrix(matrix.additionMatrix(matrix1, matrix2));
                break;
            case 2:
                displaymatrix(matrix.subtractionMatrix(matrix1, matrix2));
                break;
            case 3:
                displaymatrix(matrix.multiplicationMatrix(matrix1, matrix2));
                break;
            default:
                break;
        }
    }
    public void displaymatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col;j++){
                System.out.print("["+matrix[i][j]+"]");
            }
            System.out.println();
        }
    }
    public void menu(){
        while(true){
            try{
                System.out.println("=========Caculator Program=========");
                System.out.println("1. Addition matrix");
                System.out.println("2. Subtraction matrix");
                System.out.println("3. Multiplication matrix");
                System.out.println("4. Quit");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                if(choice == 4) break;
                switch(choice){
                    case 1:
                        System.out.println("---------Addition---------");
                        result();
                        break;
                    case 2:
                        System.out.println("---------Subtraction---------");
                        result();
                        break;
                    case 3:
                        System.out.println("---------Multiplication---------");
                        result();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Don't have this option");
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("Wrong format!");
                continue;
            }
        }
    }
}
