package unaryPredicate;

public class IsPalindrome extends CountingUnaryPredicate<String> {

    /**
     * Test whether a string is the same in reverse.
     *
     * @param object the string to be tested
     * @return true if reverse is same
     *
     * @author Wasim Ramzan
     * @version October 2020
     */

    @Override
    public boolean test(String object) {
        String newObject = object.replaceAll("[^A-Za-z]+", "").toLowerCase();
        String reverse = "";
        for (int i = newObject.length() - 1; i >= 0; i--) {
            reverse = reverse + newObject.charAt(i);
        }

        if (newObject.equals(reverse)) {
            return true;
        }
        return false;
    }
}