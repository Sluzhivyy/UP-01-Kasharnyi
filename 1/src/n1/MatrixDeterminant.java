package n1;

import java.util.Scanner;
import java.util.Random;

public class MatrixDeterminant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        Random random = new Random();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n; // Диапазон от -n до n
            }
        }


        System.out.println("Матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


        int determinant = calculateDeterminant(matrix);
        System.out.println("Определитель матрицы: " + determinant);
    }

    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }

        int determinant = 0;
        for (int i = 0; i < n; i++) {
            int[][] submatrix = new int[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i) {
                        submatrix[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        submatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }


            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(submatrix);
        }
        return determinant;
    }
}
