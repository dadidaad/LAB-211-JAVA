import java.util.*;
public class Matrix {
    public int[][] additionMatrix (int[][] matrix1, int[][]matrix2){
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] addition = new int[row1][col1];
        if(row1!= row2 || col1 != col2) return null; 
        for(int i = 0; i< row1; i++){
            for(int j = 0; j < col1; j++ ){
                addition[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return addition;
    }
    
    
    public int[][] subtractionMatrix (int[][] matrix1, int[][]matrix2){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] subtraction = new int[row][col];
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        if(row != row1 || col != col1) return null;
        for(int i = 0; i< row; i++){
            for(int j = 0; j < col; j++ ){
                subtraction[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return subtraction;
    }
    public int[][] multiplicationMatrix(int[][] matrix1, int[][]matrix2){
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] multiMatrix = new int[row1][col2];
        if(col1 != row2) return null;
        for(int i = 0; i< row1; i++){
            for(int j = 0; j <col2; j++){
                multiMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    multiMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return multiMatrix;
    }
    
}
