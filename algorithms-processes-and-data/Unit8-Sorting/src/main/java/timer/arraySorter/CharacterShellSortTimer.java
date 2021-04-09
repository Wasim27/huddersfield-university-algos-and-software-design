package timer.arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CharacterArrayGenerator;
import timer.timer.Timer;

public class CharacterShellSortTimer extends ShellSortTimer<Character> {

    @Override
    public Timer getTimer(int size) {
        ArrayGenerator<Character> generator = new CharacterArrayGenerator();
        setArray(generator.getArray(size));
        return this;
    }

    public static void main(String[] args) {
        ShellSortTimer<Character> timer = new CharacterShellSortTimer();
        timer.timingSequence(true); // long output
    }
}
