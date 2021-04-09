package hashtable;

class OpenQuadraticHashtableTest extends OpenHashtableTest {

    @Override
    public OpenHashtable<String, Integer> getHashtable(int size) {
        return new OpenQuadraticHashtable(size);
    }
}