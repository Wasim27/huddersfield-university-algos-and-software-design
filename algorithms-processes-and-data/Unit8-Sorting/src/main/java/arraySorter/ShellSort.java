package arraySorter;

public class ShellSort<T extends Comparable<? super T >> implements ArraySort<T> {

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Override
    public T[] sort(T[] array) {
        shellSort(array);
        return array;
    }

    public void shellSort(T[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                    for (int j = i; j >= h && (array[j].compareTo(array[j-h]) < 0); j -= h) {
                    exch(array, j - h, j);
                }
            }
            h = h / 3;
        }
    }
}
