package timer.arraySorter;

import arraySorter.ShellSort;
import timer.timer.Timer;

public abstract class ShellSortTimer<T extends Comparable<? super T>> extends ShellSort<T> implements Timer {

    private T[] array; // this is the array that will be sorted

    void setArray(T[] array) {
        this.array = array;
    }

    @Override
    public void timedMethod() {
        sort(array);
    }

    @Override
    public long getMaximumRuntime() {
        return 1;
    }

    @Override
    public int getMinimumTaskSize() {
        return 1;
    }

    @Override
    public int getMaximumTaskSize() {
        return 1000000000;
    }

    @Override
    public int getRunSetSize() {
        return 10;
    }
}


