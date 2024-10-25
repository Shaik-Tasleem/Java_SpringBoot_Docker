package practice;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int[][] matrix1 = new int[n][m];
        System.out.println("Input elements for matrix1");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter row size for 2nd matrix:");
        int n2 = sc.nextInt(); 
        System.out.println("Enter column size for 2nd matrix:");
        int m2 = sc.nextInt();
        if (m != n2) {
            System.out.println("The number of columns of the first matrix must match the number of rows of the second matrix");
            return;
        }
        int[][] matrix2 = new int[n2][m2];
        System.out.println("Input elements for matrix2:");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }
        int[][] res = new int[n][m2];
        for (int i = 0; i < n; i++) {          
            for (int j = 0; j < m2; j++) {     
                res[i][j] = 0;
                for (int k = 0; k < m; k++) {   
                    res[i][j] += matrix1[i][k]* matrix2[k][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
