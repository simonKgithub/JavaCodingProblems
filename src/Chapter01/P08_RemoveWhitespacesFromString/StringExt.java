package Chapter01.P08_RemoveWhitespacesFromString;

public class StringExt {

    private StringExt() {
        throw new AssertionError("인스턴스화 될 수 없음");}

    private static final String WHITESPACES = "\\s+";

    public static String removeWhitespaces(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        return str.replaceAll(WHITESPACES, "");
    }
}
