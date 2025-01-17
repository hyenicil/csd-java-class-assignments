import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MatrisTransposeTest.run();
    }
}

class MatrisTransposeTest{

    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kaca kac matrix uretilsin:");
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        int [][] matrix = MatrisTransposeUtil.createMatrix(n, m);
        PrintUtil.printMatrix(matrix);
        PrintUtil.printString("------------------------------", "\n");
        PrintUtil.printMatrix(MatrisTransposeUtil.transpose(matrix));
    }
}


class MatrisTransposeUtil{

    public static int[][] transpose(int[][] matrix) {
        int [][] transpose = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; i++)
              for(int j = 0; j < matrix[i].length; j++)
                  transpose[j][i] = matrix[i][j];
        return transpose;
      }

      public static int[][] createMatrix(int n, int m ) {
          Random random = new Random();
          int[][] matrix = new int[n][m];
          for (int i = 0; i < n; i++)
              for (int j = 0; j < m; j++)
                  matrix[i][j] = random.nextInt(10);

          return matrix;
      }

}