package arraySorter;

public class QuickSort<T extends Comparable<? super T >> implements ArraySort<T> {

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Override
    public T[] sort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(T[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int i = lo;
        int j = hi;
        T v = array[(i + j) / 2];

        while (i <= j) {
            while (array[i].compareTo(v) < 0) i++;
            while (array[j].compareTo(v) < 0) j--;

            if (i <= j) {
                exch(array, i, j);
                i++;
                j--;
            }
        }
        quickSort(array, lo, j);
        quickSort(array, i, hi);
    }
}
