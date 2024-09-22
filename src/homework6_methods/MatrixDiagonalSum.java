//Ունեք nxn չափի մատրիցա, n-ը որոշեք դուք։ Պետքա գրել ծրագիր, որը կհաշվի մատրիցայի անկյունագծերի վրայի թվերի գումարը։

package homework6_methods;

import java.util.Scanner;

public class MatrixDiagonalSum {

    static int matrixElementsSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    sum += matrix[i][j]; // or I can just do sum+= matrix[i][j] * 2, 'cause matrix's diagonal elements sum is always the same
                    sum += matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int k = 1; // number to be printed in array
        //Creating a nxn matrix with numbers starting from 1. I am pretty sure you are too lazy to set elements for 10x10 matrix
        System.out.println("Your matrix is");
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = k++;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(matrixElementsSum(matrix));
    }
}
