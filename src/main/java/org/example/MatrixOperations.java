package org.example;

public class MatrixOperations {
    public static void main(String[] args) {
        // Ініціалізація матриць A та B з типом елементів char
        char[][] A = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };

        char[][] B = {
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r'}
        };

        // Обчислення C як матричного добутку AB
        int[][] C = matrixMultiplication(A, B);

        // Вивід матриці C
        System.out.println("Результат матричного добутку (матриця C):");
        printMatrix(C);

        // Знаходження середнього значення елементів кожного рядка матриці C
        double[] rowAverages = calculateRowAverages(C);
        System.out.println("\nСереднє значення елементів кожного рядка матриці C:");
        for (int i = 0; i < rowAverages.length; i++) {
            System.out.println("Рядок " + (i + 1) + ": " + rowAverages[i]);
        }
    }

    /**
     * Метод для виконання матричного добутку матриць A і B.
     *
     * @param matrixA матриця A типу char
     * @param matrixB матриця B типу char
     * @return матриця результату типу int
     */
    private static int[][] matrixMultiplication(char[][] A, char[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int[][] C = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = 0;
                for (int k = 0; k < B.length; k++) {
                    C[i][j] += (A[i][k] - 'a' + 1) * (B[k][j] - 'a' + 1); // Переведення чару в порядковий номер букви в алфавіті
                }
            }
        }
        return C;
    }

    /**
     * Метод для обчислення середнього значення елементів кожного рядка матриці.
     *
     * @param matrix матриця типу int
     * @return масив середніх значень рядків типу double
     */
    private static double[] calculateRowAverages(int[][] matrix) {
        double[] averages = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            averages[i] = (double) sum / matrix[i].length;
        }
        return averages;
    }

    /**
     * Метод для виведення матриці на екран.
     *
     * @param matrix матриця типу int
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
