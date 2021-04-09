package arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CharacterArrayGenerator;

abstract public class CharacterSortTest extends ArraySortTest<Character> {
    @Override
    public ArrayGenerator<Character> getGenerator() {
        return new CharacterArrayGenerator();
    }
}
