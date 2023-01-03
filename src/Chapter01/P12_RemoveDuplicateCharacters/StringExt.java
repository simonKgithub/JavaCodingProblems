package Chapter01.P12_RemoveDuplicateCharacters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StringExt {
    private StringExt(){
        throw new AssertionError("인스턴스화 되지 않았습니다.");}

    public static String removeDuplicatesV1(String str) {
        if (str == null || str.isEmpty()) {
            // throw new IllegalArgumentException
            return "";
        }

        char[] chArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chArray) {
            if(sb.indexOf( String.valueOf(ch) ) == -1 ){
                sb.append(ch);
            }
        }
        return sb.toString();

    /* 내가 사용한 방법
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            String st = String.valueOf(str.charAt(i));
            if( result.indexOf(st) < 0 ){
                result.append(st);
            }
        }
        return result.toString();
    */
    }

    public static String removeDuplicatesV2(String str) {
        if (str == null || str.isEmpty()) {
            // throw new IllegalArgumentException
            return "";
        }

        char[] chArray = str.toCharArray();
        StringBuilder result = new StringBuilder();
        Set<Character> chHashSet = new HashSet<>();
        for (char ch : chArray) {
            if (chHashSet.add(ch)) {
                result.append(ch);
            }
        }
        return result.toString();

        /* 내가 사용한 방법
        char[] chArray = str.toCharArray();
        StringBuilder result = new StringBuilder();
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for (char ch : chArray) {
            if ( !linkedHashSet.contains(ch) ) {
                linkedHashSet.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
         */
    }

    public static String removeDuplicatesV3(String str) {
        if (str == null || str.isEmpty()) {
            // throw new IllegalArgumentException
            return "";
        }
        return Arrays.asList(str.split("")).stream()
                .distinct()
                .collect(Collectors.joining());

        /* 내가 사용한 방법
        return str.chars().mapToObj(ch -> String.valueOf(ch) ).distinct().collect(Collectors.toList()).toString();
        */

    }
}
