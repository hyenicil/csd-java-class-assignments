import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HistogramUtilTest.run();
    }
}

class HistogramUtilTest {

    public static void run() {
        Random rand = new Random();
        int [] a = ArrayUtil.randomData(rand, 10, 1,9);
        print(a);
        System.out.println();
        print(ArrayUtil.histogramData(a,10));
    }
    public static void print(int[] a) {
        for (int j : a) System.out.print(j +" ");
    }
}

class ArrayUtil {

    public static int [] histogramData(int [] a, int n) {
        int [] result = new int[n];
        for(int x : a)
            ++result[x];
        return result;
    }

    public static int[] randomData(Random random, int count, int in, int out) {
        int [] result = new int[count];
        for (int i = 0; i < count; i++)
            result[i] = random.nextInt(in,out);
        return result;
    }
}