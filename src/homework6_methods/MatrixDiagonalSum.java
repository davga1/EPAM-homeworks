//Ունեք nxn չափի մատրիցա, n-ը որոշեք դուք։ Պետքա գրել ծրագիր, որը կհաշվի մատրիցայի անկյունագծերի վրայի թվերի գումարը։

package homework6_methods;

import java.util.Scanner;

public class MatrixDiagonalSum {

    static int matrixElementsSum(int[][] matrix) {
        int sum = 0;
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                    sum += matrix[length - 1 - i][length - 1 - j];
                }
            }
        }
        return length % 2 == 0 ? sum : sum - matrix[length / 2][length / 2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int k = 1; // number to be printed in array
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
