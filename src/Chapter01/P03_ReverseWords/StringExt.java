package Chapter01.P03_ReverseWords;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringExt {

    private static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");

    public static String reverseWordsV1(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }

            reversedString.append(reversedWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    public static String reverseWordsV2(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect((Collectors.joining(WHITESPACE)));
    }

    public static String reverse(String str){

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        return new StringBuilder(str).reverse().toString();
    }
}
