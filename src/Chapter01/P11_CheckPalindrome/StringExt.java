package Chapter01.P11_CheckPalindrome;

import java.util.stream.IntStream;

public class StringExt {
    private StringExt(){
        throw new AssertionError("인스턴스화 되지 않습니다.");}

    public static boolean isPalindromeV1(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeV2(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return false;
        }

        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
    //        int right = str.length() - 1;
    //        for (int left = 0; left < str.length(); left++) {
    //            if (str.charAt(left) != str.charAt(right)) {
    //                return false;
    //            }
    //            right--;
    //        }

        return true;
    }

    public static boolean isPalindromeV3(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return false;
        }

        return str.equals(new StringBuilder(str).reverse().toString());

    //        int n = str.length();
    //        StringBuilder sbLeft = new StringBuilder();
    //        StringBuilder sbRight = new StringBuilder();
    //
    //        for (int i = 0; i < n / 2 ; i++) {
    //            sbLeft.append(str.charAt(i));
    //            sbRight.append(str.charAt(n - i - 1));
    //        }
    //
    //        return sbLeft.toString().equals(sbRight.toString());
    }

    public static boolean isPalindromeV4(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return false;
        }

        // true인 것이 하나라도 있으면 false / 다 false 면 true
    //        return IntStream.range(0, str.length() / 2)
    //                .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
        // 모두 true이면 true / 하나라도 false 면 false
        return IntStream.range(0, str.length() / 2)
                .allMatch(p -> str.charAt(p) == str.charAt(str.length() - p - 1));
    }
}
