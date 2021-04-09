package timer.arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CharacterArrayGenerator;
import timer.timer.Timer;

public class CharacterSelectionSortTimer extends SelectionSortTimer<Character> {

    @Override
    public Timer getTimer(int size) {
        ArrayGenerator<Character> generator = new CharacterArrayGenerator();
        setArray(generator.getArray(size));
        return this;
    }

    public static void main(String[] args) {
        SelectionSortTimer<Character> timer = new CharacterSelectionSortTimer();
        timer.timingSequence(true); // long output
    }
}
