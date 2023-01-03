package Chapter01.P13_RemoveGivenCharacter;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringExt {
    private StringExt(){ throw new AssertionError("인스턴스화 되지 않음");}

    public static String removeCharacterV1(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();
        for (char currentCh : chArray) {
            if (currentCh != ch) {
                sb.append(currentCh);
            }
        }
        return sb.toString();
    }

    public static String removeCharacterV2(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
    }

    public static String removeCharacterV3(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        return str.chars()
                .filter(c -> c != ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String removeCharacterV4(String str, String ch) {
        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        if (ch.codePointCount(0, ch.length()) != 1) {
            return ""; //주어진 문자열에서 유니코드 문자가 1개 이상인 경우
        }

        int codePoint = ch.codePointAt(0);

        return str.codePoints()
                .filter(c -> c != codePoint)
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.joining());
    }
}
