package Chapter01.P18_CheckTwoStringsAnagrams;

import java.util.Arrays;

public class StringExt {

    private static final int EXTENDED_ASCII_CODES = 256;

    private StringExt(){throw new AssertionError("인스턴스화 되지 않음");}

    public static boolean isAnagramV1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            //throw new IllegalArgumentException("문자열이 빈 값은 안됩니다.");
            return false;
        }

        // \\s로 공백제거, 소문자로 통일
        char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chStr2 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (chStr1.length != chStr2.length) {
            return false;
        }

        //정렬
        Arrays.sort(chStr1);
        Arrays.sort(chStr2);

        return Arrays.equals(chStr1, chStr2);
    }

    public static boolean isAnagramV2(String str1, String str2) {

        if (str1 == null || str2 == null
                || str1.isEmpty() || str2.isEmpty()) {
            // throw IllegalArgumentException
            return false;
        }
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        return Arrays.equals(
                str1.chars().sorted().toArray(),
                str2.chars().sorted().toArray()
        );
    }

    public static boolean isAnagramV3(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            //throw new IllegalArgumentException("문자열이 빈 값은 안됩니다.");
            return false;
        }

        int[] chCounts = new int[EXTENDED_ASCII_CODES];
        char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chStr2 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (chStr1.length != chStr2.length) {
            return false;
        }

        for (int i = 0; i < chStr1.length; i++) {
            chCounts[chStr1[i]]++;
            chCounts[chStr2[i]]--;
        }

        for (int i = 0; i < chCounts.length; i++) {
            if (chCounts[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
