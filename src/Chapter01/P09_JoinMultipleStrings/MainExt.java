package Chapter01.P09_JoinMultipleStrings;

import java.util.concurrent.TimeUnit;

public class MainExt {

    private static final String TEXT_1 = "Illinois";
    private static final String TEXT_2 = "Mathematics";
    private static final String TEXT_3 = "and";
    private static final String TEXT_4 = "Science";
    private static final String TEXT_5 = "Academy";

    public static void main(String[] args) {
        System.out.println("구분자로 여러 문자열 합치기 \n");
        System.out.println("입력문자 : " + TEXT_1 + ", " + TEXT_2 + ", " +
                TEXT_3 + ", " + TEXT_4 + ", " + TEXT_5 + "\n");

        System.out.println("첫번째 방법 : StringBuilder 이용하기");
        long startTimeV1 = System.nanoTime();

        String stringV1 = StringExt.joinByDelimiterV1(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("결과 : " + stringV1);
        System.out.println();

        System.out.println("두번째 방법 : 자바8 함수형의 String.join() 이용하기");
        long startTimeV2 = System.nanoTime();

        String stringV2 = String.join(" ", TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("결과 : " + stringV2);
        System.out.println();

        System.out.println("세번째 방법 : 자바8 Collectors.joining() 이용하기");
        long startTimeV3 = System.nanoTime();

        String stringV3 = StringExt.joinByDelimiterV2(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("결과 : " + stringV3);
        System.out.println();

        System.out.println("네번째 방법 : 자바8 StringJoiner 이용하기");
        long startTimeV4 = System.nanoTime();

        String stringV4 = StringExt.joinByDelimiterV3(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("결과 : " + stringV4);
        System.out.println();
    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행시간 : " + time + " ns ( "+
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
