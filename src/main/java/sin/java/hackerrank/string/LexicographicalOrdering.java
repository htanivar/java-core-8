package sin.java.hackerrank.string;

import java.util.Arrays;

public class LexicographicalOrdering {
    public String getSmallestAndLargest(String inputStr, int len) {
        String smallest = "";
        String largest = "";

        int upto = inputStr.length() - len + 1;
        String[] fetchedArray = new String[upto];
        for (int i = 0; i < upto; i++) {
            String fetchedSubstring = inputStr.substring(i, len + i);
            fetchedArray[i] = fetchedSubstring;
        }

        Arrays.sort(fetchedArray,String.CASE_INSENSITIVE_ORDER);
        smallest = fetchedArray[0];
        largest = fetchedArray[upto-1];


        return smallest + "\n" + largest;
    }

}
