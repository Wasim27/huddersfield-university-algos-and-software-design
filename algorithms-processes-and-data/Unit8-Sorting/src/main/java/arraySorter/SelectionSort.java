package arraySorter;

public class SelectionSort<T extends Comparable<? super T>> implements ArraySort<T> {

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    @Override
    public T[] sort(T[] array) {
        int N = array.length;

        for(int i = 0; i < N; i++){
            int minIndex = i;
            for(int j = i+1; j < N; j++) {
                if (array[j].compareTo(array[minIndex]) < 0)
                    minIndex = j;
                exch(array, i, minIndex);
            }
        }
        return array;
    }
}

