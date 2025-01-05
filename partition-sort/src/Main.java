public class Main {
    public static void main(String[] args) {
        PartitionSortTest.run();
    }
}
class PartitionSortTest {
    public static void run() {
        int[] val = {9,2,-8,67,23,34,-5,14,22,68,45,-10,3,16};
        print(val);
        System.out.println("Eşik değeri: 23");
        int partitionPoint = PartitionSort.sorting(val, 23);
        print(val);
        System.out.println("Bölümleme Noktası:" + partitionPoint);
    }

    public static void print(int[] val) {
        for(int i :val)
            System.out.print(i+" ");
    }
}

class PartitionSort {

    public static int sorting(int[] a, int threshold) {
        int index= 0;

        while(index != a.length && a[index] < threshold) {
            ++index;
        }
        if(index == a.length)
            return index;

        for(int i = index + 1; i < a.length; ++i) {
            if (a[i] < threshold)
                swap(a, i, index++);
        }
        return index;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}