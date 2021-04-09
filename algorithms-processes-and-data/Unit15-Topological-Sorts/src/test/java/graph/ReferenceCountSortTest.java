package graph;

class ReferenceCountSortTest extends TopologicalSortTest<ReferenceCountSort<Integer>>  {

    @Override
    protected ReferenceCountSort<Integer> newSort() {
        return new ReferenceCountSort<>();
    }
}