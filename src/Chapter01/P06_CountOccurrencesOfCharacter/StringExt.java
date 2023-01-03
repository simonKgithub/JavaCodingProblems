package Chapter01.P06_CountOccurrencesOfCharacter;

import java.util.stream.IntStream;

public class StringExt {
    private StringExt() {
        throw new AssertionError("인스턴스화 할 수 없습니다.");
    }

    public static int countOccurrencesOfACertainCharacterV1(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return -1;
        }

        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public static int countOccurrencesOfACertainCharacterV2(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return -1;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }

    public static long countOccurrencesOfACertainCharacterV3(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        return str.chars()
                .filter( c -> c == ch)
                .count();
    }

    public static int countOccurrencesOfACertainCharacterVCP1(String str, String ch) {
        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            return -1;
        }

        if (ch.codePointCount(0, ch.length()) > 1) {
            return -1; // there is more than 1 Unicode character in the given String
        }

        int result = str.length() - str.replace(ch, "").length();

        return ch.length() == 2 ? result / 2 : result;
    }

    public static int countOccurrencesOfACertainCharacterVCP2(String str, String ch) {
        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            // or throw IllegalArgumentException
            return -1;
        }

        if (ch.codePointCount(0, ch.length()) > 1) {
            return -1; // there is more than 1 Unicode character in the given String
        }

        int count = 0;
        int codePoint = ch.codePointAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.codePointAt(i) == codePoint) {
                count++;
            }
        }
        return count;
    }

    public static long countOccurrencesOfACertainCharacterVCP3(String str, String ch) {
        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            // or throw IllegalArgumentException
            return -1;
        }
        if (ch.codePointCount(0, ch.length()) > 1) {
            return -1; // there is more then Unicode character in the given String
        }

        int codePoint = ch.codePointAt(0);

        return str.codePoints()
                    .filter( c -> c == codePoint)
                    .count();
    }
}
