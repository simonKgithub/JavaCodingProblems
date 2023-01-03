package Chapter01.P09_JoinMultipleStrings;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringExt {
    private StringExt(){
        throw new AssertionError("인스턴스 화 될 수 없습니다.");}

    public static String joinByDelimiterV1(char delimiter, String... args) {
        if (args == null || args.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);
        }
        //마지막에 ' '를 append하지 않기 위해
        result.append(args[i]);

        return result.toString();
    }

    public static String joinByDelimiterV2(char delimiter, String... args) {
        if (args == null || args.length == 0) {
            // or throw IllegalArgumentException
            return "";
        }

        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }

    public static String joinByDelimiterV3(char delimiter, String... args) {
        if (args == null || args.length == 0) {
            // or throw IllegalArgumentException
            return "";
        }

        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

        for (String arg : args) {
            joiner.add(arg);
        }

        return joiner.toString();
    }
}
