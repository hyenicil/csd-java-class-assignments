import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DiagonalTest.run();
    }
}

class DiagonalTest {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Olusturmak istediginiz matrix boyutunu giriniz:");
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        int a[][] = DiagonalUtil.createMatrix(n,m);
        PrintUtil.printMatrix(a);
        PrintUtil.printInt(DiagonalUtil.sumDiagonal(a));
    }
}
class DiagonalUtil {

    public static int[][] createMatrix(int n, int m) {
        Random rand = new Random();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    public static int sumDiagonal(int[][] matrix) {
        int sum=0;
        for(int i=0 ; i<matrix.length ; i++)
            sum+=matrix[i][i];
        return sum;
    }





}

