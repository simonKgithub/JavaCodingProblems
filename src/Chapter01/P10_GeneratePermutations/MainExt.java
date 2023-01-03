package Chapter01.P10_GeneratePermutations;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MainExt {
    private static final String TEXT = "ABC";

    public static void main(String[] args) {
        System.out.println("모든 순열 생성");

        System.out.println("입력 문자 : " + TEXT + "\n");

        System.out.println("첫 번쩨 방법 : Set에 저장");
        long startTimeV1 = System.nanoTime();

        Set<String> collector = StringExt.permuteAndStore(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("결과 : " + collector);
        System.out.println();

        System.out.println("두 번쩨 방법 : 출력");
        long startTimeV2 = System.nanoTime();

        System.out.print("결과 : ");
        StringExt.permuteAndPrint(TEXT);
        System.out.println();
        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println();


        System.out.println("세 번쩨 방법 : Stream<String>울 리턴");
        long startTimeV3 = System.nanoTime();

        Stream<String> result = StringExt.permuteAndReturnStream(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("결과 : ");
        result.forEach(System.out::println);
        System.out.println();

        System.out.println("네 번쩨 방법 : Stream을 출력");
        long startTimeV4 = System.nanoTime();

        System.out.print("결과 : ");
        StringExt.permuteAndPrintStream(TEXT);

        System.out.println();
        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println();
    }


    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
