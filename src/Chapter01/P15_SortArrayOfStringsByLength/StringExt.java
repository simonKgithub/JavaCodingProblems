package Chapter01.P15_SortArrayOfStringsByLength;

import java.util.Arrays;
import java.util.Comparator;

public class StringExt {
    private StringExt(){throw new AssertionError("인스턴스화 될 수 없음");}

    public enum Sort { ASC, DESC }

    public static void sortArrayByLengthV1(String[] strs, Sort direction) {
        if (strs == null || direction == null || strs.length == 0) {
            return;
        }

        if(direction.equals(Sort.ASC)){
            Arrays.sort(strs,
                    (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
        } else {
            Arrays.sort(strs,
                    (String s1, String s2) -> (-1)*Integer.compare(s1.length(), s2.length()));
        }
    }
    public static void sortArrayByLengthV2(String[] strs, Sort direction) {
        if (strs == null || direction == null || strs.length == 0) {
            return;
        }

        if (direction.equals(Sort.ASC)) {
            Arrays.sort(strs, Comparator.comparingInt(String::length));
        } else {
            Arrays.sort(strs, Comparator.comparingInt(String::length).reversed());
        }
    }
    public static String[] sortArrayByLengthV3(String[] strs, Sort direction) {
        if (strs == null || direction == null || strs.length == 0) {
            return new String[0];
        }

        if (direction.equals(Sort.ASC)) {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        }

    }
}