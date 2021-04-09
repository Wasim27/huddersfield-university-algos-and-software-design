package arrayGenerator;

import static org.junit.jupiter.api.Assertions.*;

class CleverRandomListingGeneratorTest extends RandomListingGeneratorTest {
    protected ArrayGenerator getGenerator(int size) {
        return new CleverRandomListingGenerator(size); // make getGenerator return a CleverRandomListingGenerator
    }
}