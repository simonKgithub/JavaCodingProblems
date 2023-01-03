package Chapter01.P13_RemoveGivenCharacter;

import java.util.concurrent.TimeUnit;

public class MainExt {

    private static final String TEXT = "oobotooorogshŜoootorgo";
    private static final char CHAR = 'Ŝ';
    private static long startTime = 0;

    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
    private static final String CHAR_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_CPS = "💕"; // Unicode: \uD83D\uDC95, Code Point: 128149

    public static void main(String[] args) {
        System.out.println("주어진 문자 제거하기\n");
        System.out.println("입력 문자 : " + TEXT);
        System.out.println("제거 문자 : " + CHAR + "\n");

        System.out.println("-----------------------------------------");
        System.out.println("첫 번째 방법 : StringBuilder 이용");
        startTime = System.nanoTime();

        String resultV1 = StringExt.removeCharacterV1(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과 : " + resultV1);
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("두 번째 방법 : 정규식 표현 이용");
        startTime = System.nanoTime();

        String resultV2 = StringExt.removeCharacterV2(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과 : " + resultV2);
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("세 번째 방법 : 자바8 함수형 스타일 이용");
        startTime = System.nanoTime();

        String resultV3 = StringExt.removeCharacterV3(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과 : " + resultV3);
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("아스키코드와 유니코드를 모두 지원할 때 사용하는 방법");
        System.out.println("입력 문자 : " + TEXT_CP);
        System.out.println("제거 문자1 : " + CHAR_CP);
        System.out.println("제거 문자2 : " + CHAR_CPS + "\n");
        System.out.println("-----------------------------------------");
        System.out.println("네 번째 방법 : 자바8 함수형 스타일 이용");
        startTime = System.nanoTime();

        String resultV4 = StringExt.removeCharacterV4(TEXT_CP, CHAR_CP);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과(제거문자1) : " + resultV4);
        System.out.println();

        startTime = System.nanoTime();

        String resultV5 = StringExt.removeCharacterV4(TEXT_CP, CHAR_CPS);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("결과(제거문자2) : " + resultV5);
        System.out.println();

    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
