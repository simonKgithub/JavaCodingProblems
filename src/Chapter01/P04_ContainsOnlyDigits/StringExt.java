package Chapter01.P04_ContainsOnlyDigits;

public class StringExt {
    /**
     * Note : For Unicode supplementary characters use codePointAt() instead of charAt()
     * and codePoints() instead of chars()
     */

    public static boolean containOnlyDigitsV1(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean containOnlyDigitsV2(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        return str.matches("[0-9]+");
    }

    public static boolean containOnlyDigitsV3(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        //하나라도 조건을 만족하면 true 반환
        return !str.chars().anyMatch(n -> !Character.isDigit(n));
    }

    public static boolean containOnlyDigitsV4(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        //하나라도 조건을 만족하면 true 반환
        return str.chars().allMatch(n -> Character.isDigit(n));
    }
}
