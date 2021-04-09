package graph;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSortTest extends TopologicalSortTest<DepthFirstSort<Integer>>  {

    @Override
    protected DepthFirstSort<Integer> newSort() {
        return new DepthFirstSort<>();
    }
}