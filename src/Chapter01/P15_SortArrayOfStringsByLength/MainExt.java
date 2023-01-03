package Chapter01.P15_SortArrayOfStringsByLength;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainExt {

    private static String[] strs = {"one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten"};

    private static long startTime = 0;

    public static void main(String[] args) {
        System.out.println("문자열 배열을 길이 순으로 정렬\n");
        System.out.println("입력 배열(정렬안됨) : " + Arrays.toString(strs));

        System.out.println("-----------------------------------------");
        System.out.println("첫 번째 방법 : Integer.compare() 이용");

        startTime = System.nanoTime();
        StringExt.sortArrayByLengthV1(strs, StringExt.Sort.ASC);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과(asc) : " + Arrays.toString(strs));
        System.out.println();

        startTime = System.nanoTime();
        StringExt.sortArrayByLengthV1(strs, StringExt.Sort.DESC);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과(desc) : " + Arrays.toString(strs));
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("두 번째 방법 : Comparator.comparingInt() 이용");

        startTime = System.nanoTime();
        StringExt.sortArrayByLengthV2(strs, StringExt.Sort.ASC);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과(asc) : " + Arrays.toString(strs));
        System.out.println();

        startTime = System.nanoTime();
        StringExt.sortArrayByLengthV2(strs, StringExt.Sort.DESC);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과(desc) : " + Arrays.toString(strs));
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("세 번째 방법 : 자바8 함수형 스타일 이용");

        startTime = System.nanoTime();
        String[] result31 = StringExt.sortArrayByLengthV3(strs, StringExt.Sort.ASC);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과(asc) : " + Arrays.toString(result31));
        System.out.println();

        startTime = System.nanoTime();
        String[] result32 = StringExt.sortArrayByLengthV3(strs, StringExt.Sort.DESC);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과(desc) : " + Arrays.toString(result32));
        System.out.println();
    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
