public class Main {
    public static void main(String[] args) {
        SelectionSortTest.run();
    }
}

class SelectionSortTest {
    public static void run() {
        int[] val = {4,8,87,1,6,67,13,56};
        SelectionSort.selectionSort(val);
        print(val);
        System.out.println();
        SelectionSort.selectionSort(val,true);
        print(val);

    }

    public static void print(int[] array) {
        for (int a : array)
            System.out.print(a + " ");
    }
}

class SelectionSort {

    public static void selectionSort(int[] arr) {
        selectionSort(arr,false);
    }
    public static void selectionSort(int[] arr, boolean t) {
        if (t) {
            selectionSortAscending(arr);
        } else {
            selectionSortDescending(arr);
        }
    }

    private static void selectionSortDescending(int[] arr) {
        int max, maxIndex;
        for(int i = 0; i < arr.length-1; ++i) {
            max = arr[i];
            maxIndex = i;
            for(int k = i+1; k<arr.length; ++k)
                if(arr[k] > max) {
                    max = arr[k];
                    maxIndex = k;
                }
            arr[maxIndex] = arr[i];
            arr[i] = max;

        }
    }

    private static void selectionSortAscending(int[] arr) {
        int min, minIndex;
        for(int i = 0; i < arr.length-1; ++i) {
            min = arr[i];
            minIndex = i;
            for(int k = i+1; k < arr.length; ++k)
                if(arr[k] < min) {
                    min = arr[k];
                    minIndex = k;
                }
            arr[minIndex] = arr[i];
            arr[i] = min;

        }
    }
}

