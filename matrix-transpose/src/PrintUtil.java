public class PrintUtil {

    public static void printString(String a) {
        System.out.printf("%s",a);
    }

    public static void printString(String a, String b) {
        System.out.printf("%s%s",a,b);
    }

    public static void printInt(int a) {
        printInt(1,a,"","");
    }

    public static void printInt(int a, String seperator, String seperator2) {
        printInt(1, a, seperator, seperator2);
    }

    public static void printInt(int count, int a, String seperator, String seperator2) {
        System.out.printf(String.format("%%s%%0%dd%%s", count), seperator2,a, seperator);
    }

    public static void printInt(int a, String seperator) {
        printInt(a, seperator, seperator);
    }

    public static void printArray(int[] array) {
        printArray(array, " ");
    }

    public static void printArray(int[] array, String seperator) {
        printArray(array, seperator, "[", "]");
    }

    public static void printArray(int[] array, String seperator, String end) {
        printArray(array, seperator, "", end);
    }

    public static void printArray(int[] array, String seperator, String start, String end) {
        printString(start);
        for (int a : array)
            printInt( a, seperator);
        printString(end);
    }

    public static void printMatrix(int[][] matrix) {
        printMatrix(matrix, " ");
    }

    public static void printMatrix(int[][] array, String seperator) {
        printMatrix(array, seperator, "", "\n");
    }

    public static void printMatrix(int[][] matrix, String seperator, String start, String end) {
        for (int a[] : matrix)
            printArray(a, seperator, start, end);
    }

}
