public class Main {
    public static void main(String[] args) {
        BubbleSortTest.run();
    }
}

class BubbleSortTest {

    public static void run() {
        int[] val = {4,8,87,1,6,67,13,56};
        print(BubbleSort.bubbleSorting(val,true));
        System.out.println();
        print(BubbleSort.bubbleSorting(val));
        System.out.println();
        System.out.println();
        print(BubbleSort.bubbleSortingTwo(val,true));
        System.out.println();
        print(BubbleSort.bubbleSortingTwo(val));
    }

    public static void print(int[] a){
        for (int val: a)
            System.out.print(val + " ");
    }
}

class BubbleSort {

    public static int[] bubbleSorting(int[] a) {
        return bubbleSorting(a,false);
    }

    public static int[] bubbleSorting(int[] a, boolean desc) {
        return desc ? bubbleSortingDescending(a): bubbleSortingAsceding(a);
    }

    private static int[] bubbleSortingAsceding(int[] a) {
        int count = a.length;
        while (count-->0){
            for(int i = 0, k = 1; i < a.length-1 ;i++,k++)
                if(a[i] > a[k])
                    swap(a,i,k);
        }
        return a;
    }
    private static int[] bubbleSortingDescending(int[] a) {
        int count = a.length;
        while (count-->0){
            for(int i = 0, k = 1; i < a.length-1 ;i++,k++)
                if(a[i] < a[k])
                    swap(a,i,k);
        }
        return a;
    }


    public static int[] bubbleSortingTwo(int[] a) {
        return bubbleSortingTwo(a,false);
    }

    public static int[] bubbleSortingTwo(int[] a, boolean desc) {
        return desc ? bubbleSortingDescendingTwo(a): bubbleSortingAscedingTwo(a);
    }

    private static int[] bubbleSortingDescendingTwo(int[] a) {
        for(int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length-1-i; j++)
                if(a[j+1] > a[j])
                    swap(a,j,j+1);
        return a;
    }

    private static int[] bubbleSortingAscedingTwo(int[] a) {
        for(int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length-1-i; j++)
                if(a[j+1] < a[j])
                    swap(a,j,j+1);
        return a;
    }

    private static int[] swap(int[] a, int i, int k) {
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
        return a;
    }



}

/*Bu kodu daha profesyonel hale getirmek için şu değişiklikler yapılabilir:

1. **Kodun okunabilirliğini artırma**: Daha anlamlı değişken isimleri kullanın (örneğin, `count` yerine `remainingIterations` gibi).
2. **Yinelenen kodu azaltma**: Hem artan (ascending) hem de azalan (descending) sıralama için aynı temel işlevselliği kullanan bir genel metot yazabilirsiniz. Sıralama düzeni bir lambda ifadesi veya `Comparator` gibi bir parametre ile belirtilebilir.
3. **Yorum ekleme**: Kodun ne yaptığı ve nasıl çalıştığı hakkında açıklamalar ekleyin.
4. **Gereksiz tekrarı azaltma**: `k = i + 1` zaten `i` üzerinden türetilebileceği için gereksizdir.

Aşağıda önerilen daha profesyonel bir yaklaşım bulunuyor:

```java
import java.util.function.BiPredicate;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        bubbleSort(array, (a, b) -> a > b); // Artan sıralama
        printArray(array);

        bubbleSort(array, (a, b) -> a < b); // Azalan sıralama
        printArray(array);
    }

    public static void bubbleSort(int[] array, BiPredicate<Integer, Integer> comparator) {
        int n = array.length;
        boolean swapped;

        // Dış döngü: her iterasyonda en büyük veya en küçük eleman sona taşınır
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (comparator.test(array[i], array[i + 1])) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
            n--; // Son eleman zaten sıralı olduğundan, bir daha kontrol edilmez
        } while (swapped);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```

### Açıklamalar
1. **`BiPredicate` kullanımı**:
   - Sıralama düzenini belirtmek için esneklik sağlar.
   - `a > b` artan sıralama, `a < b` azalan sıralama için kullanılır.

2. **Daha az yinelenen kod**:
   - Artan ve azalan sıralama aynı `bubbleSort` metodu tarafından yapılır.

3. **Performans iyileştirmesi**:
   - Dış döngü, bir turda değişiklik yapılmadığında durur (`swapped` değişkeni).
   - Sıralama yapılmış elemanları tekrar kontrol etmeyi engellemek için `n--` kullanılır.

Bu yapı, daha esnek, okunabilir ve bakım yapılabilir bir çözümdür.

* */