package arraySorter;

public class IntegerBubbleSortTest extends IntegerSortTest {
    @Override
    public ArraySort<Integer> getSorter() {
        return new BubbleSort<Integer>();
    }
}
