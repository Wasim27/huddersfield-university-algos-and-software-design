package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;

abstract public class IntegerSortTest extends ArraySortTest<Integer> {
    @Override
    public ArrayGenerator<Integer> getGenerator() {
        return new IntegerArrayGenerator();
    }
}
