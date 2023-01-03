package Chapter01.P03_ReverseWords;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Strings {

    private static final Pattern PATTERN = Pattern.compile(" +");
    private static final String WHITESPACE = " ";

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String reverseWordsV1(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {

            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }

            reversedString.append(reverseWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    public static String reverseWordsV2(String str) {

        // or throw IllegalArgumentException
        if (str == null || str.isEmpty()) {
            return "";
        }

        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(WHITESPACE));
    }

    public static String reverse(String str) {

        // or throw IllegalArgumentException
        if (str == null || str.isEmpty()) {
            return "";
        }

        return new StringBuilder(str).reverse().toString();
    }

}
