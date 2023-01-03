package Chapter01.P16_CheckStringContainsSubstring;

import java.util.regex.Pattern;

public class StringExt {
    private StringExt () { throw new AssertionError("인스턴스화 되지 않음");}

    public static boolean containsV2(String text, String subtext){
        if (text == null || subtext == null || text.isEmpty() || subtext.isEmpty()) {
            return false;
        }

        return text.matches("(?i).*" + Pattern.quote(subtext) + ".*");
    }
    public static boolean containsV3(String text, String subtext){
        if (text == null || subtext == null || text.isEmpty() || subtext.isEmpty()) {
            return false;
        }

        return text.indexOf(subtext) > -1 ;
    }
}
