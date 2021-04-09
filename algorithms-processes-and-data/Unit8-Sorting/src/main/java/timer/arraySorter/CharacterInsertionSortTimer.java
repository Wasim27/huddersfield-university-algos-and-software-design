package timer.arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CharacterArrayGenerator;
import timer.timer.Timer;

public class CharacterInsertionSortTimer extends InsertionSortTimer<Character> {

    @Override
    public Timer getTimer(int size) {
        ArrayGenerator<Character> generator = new CharacterArrayGenerator();
        setArray(generator.getArray(size));
        return this;
    }

    public static void main(String[] args) {
        InsertionSortTimer<Character> timer = new CharacterInsertionSortTimer();
        timer.timingSequence(true); // long output
    }
}

