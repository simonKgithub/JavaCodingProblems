package Chapter01.P12_RemoveDuplicateCharacters;

import java.util.concurrent.TimeUnit;

public class MainExt {
    private static final String TEXT = "!ABCBA;C D E-D  D  DFA;";

        public static void main(String[] args) {
        System.out.println("중복 문자 제거\n");
        System.out.println("입력 문자 : " + TEXT + "\n");

        System.out.println("첫 번째 방법 : StringBuilder 와 index() 사용");
        long startTimeV1 = System.nanoTime();

        String resultV1 = StringExt.removeDuplicatesV1(TEXT);

        System.out.println("출력 문자 : " + resultV1);
        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println();

        System.out.println("두 번째 방법 : HashSet and StringBuilder 사용");
        long startTimeV2 = System.nanoTime();

        String resultV2 = StringExt.removeDuplicatesV2(TEXT);

        System.out.println("출력 문자 : " + resultV2);
        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println();

        System.out.println("세 번째 방법 : 자바8 함수형 스타일 사용");
        long startTimeV3 = System.nanoTime();

        String resultV3 = StringExt.removeDuplicatesV3(TEXT);

        System.out.println("출력 문자 : " + resultV3);
        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println();
    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns (" +
                        TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
