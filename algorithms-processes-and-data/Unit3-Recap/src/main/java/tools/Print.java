package tools;

/**
 * Print values (actually construct Strings) in a human friendly fashion.
 */
public class Print {
    /**
     * Construct a String for an ordinal number (1st, 2nd, 3rd, 4th, etc.).
     * @param number the number for which the ordinal string is to be constructed.
     * @return the ordinal string value for the number.
     */
    public static String ordinal(int number) {
        String suffix;
        if ((number % 100)/10 == 1) { // 10th, 11th, etc.
            suffix = "th";
        } else {
            switch (number % 10) {
                case 1: suffix = "st"; break;
                case 2: suffix = "nd"; break;
                case 3: suffix = "rd"; break;
                default: suffix = "th";
            }
        }
        return number + suffix;
    }

    /**
     * Construct a String for an array.  All elements will be shown in a small array, ellipsis will be used for larger
     * arrays.
     * @param array the array.
     * @param maxShow the maximum number of entries in the array to be included in the string before ellipsis is used.
     * @return a string (partially) representing the array.
     */
    public static String array(int[] array, int maxShow) {
        if (array == null) return "null";
        if (array.length == 0) return "[]";
        StringBuilder builder = new StringBuilder("[" + array[0]);
        int index = 1;
        while (index < maxShow && index < array.length) {
            builder.append("," + array[index++]);
        }
        if (array.length <= maxShow) {
            builder.append("]");
        } else {
            builder.append(",...]");
        }
        return builder.toString();
    }

    private final static int DEFAULT_ARRAY_SHOW_LENGTH = 5;

    /**
     * Construct a String for an array.  All elements will be shown in arrays with up to DEFAULT_ARRAY_SHOW_LENGTH
     * entries, ellipsis will be used for larger arrays.
     * @param array the array.
     * @return a string (partially) representing the array.
     */
    public static String array(int[] array) {
        return array(array,DEFAULT_ARRAY_SHOW_LENGTH);
    }
}
