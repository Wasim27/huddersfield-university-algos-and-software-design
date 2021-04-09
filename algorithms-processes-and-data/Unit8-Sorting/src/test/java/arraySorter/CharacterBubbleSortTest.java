package arraySorter;

public class CharacterBubbleSortTest extends CharacterSortTest {
    @Override
    public ArraySort<Character> getSorter() {
        return new BubbleSort<Character>();
    }
}
