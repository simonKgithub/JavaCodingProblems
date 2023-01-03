package Chapter01.P02_FirstNonRepeatedCharacter;

import java.util.concurrent.TimeUnit;

public class MainExt {
    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    // Ӝ -> Unicode: \u04DC, Code Point: 1244
    // 💕 -> Unicode: \uD83D\uDC95, Code Point: 128149
    private static final String TEXT_CP = "😍 💕 I Ӝ love you Ӝ so much 😍";

    public static void main(String[] args) {
        System.out.println("002. 반복되지 않는 첫번째 문자 찾기");
        System.out.println("Input : " + TEXT);
        System.out.println();

        //첫번째 해결방법
        System.out.println("첫번째 해결 방법 : Loop와 Break 사용");
        //시간체크 시작
        long startTimeV1 = System.nanoTime();
        //메서드
        char firstcharV1 = StringExt.firstNonRepeatedCharacterV1(TEXT);
        //시간체크 끝
        displayExecutionTime(System.nanoTime() - startTimeV1);
        //답표출
        System.out.println("첫번째 답 : " + firstcharV1);

        System.out.println();

        //두번째 해결방법
        System.out.println("두번째 해결 방법 : 256 ASCII codes 해결 ");
        //시간체크 시작
        long startTimeV2 = System.nanoTime();
        //메서드
        char firstcharV2 = StringExt.firstNonRepeatedCharacterV2(TEXT);
        //시간체크 끝
        displayExecutionTime(System.nanoTime() - startTimeV2);
        //답 표출
        System.out.println("두번째 답 : " + firstcharV2);

        System.out.println();

        //세번째 해결방법
        System.out.println("세번째 해결 방법 : LinkedHashMap 솔루션");
        //시간체크 시작
        long startTimeV3 = System.nanoTime();
        //메서드
        char firstcharV3 = StringExt.firstNonRepeatedCharacterV3(TEXT);
        //시간체크 끝
        displayExecutionTime(System.nanoTime() - startTimeV3);
        //답표출
        System.out.println("세번째 답 : " + firstcharV3);

        System.out.println();

        //네번째 해결방법
        System.out.println("네번째 해결 방법 : Java-8 함수형");
        //시간체크 시작
        long startTimeV4 = System.nanoTime();
        //메서드
        char firstcharV4 = StringExt.firstNonRepeatedCharacterV4(TEXT);
        //시간체크 끝
        displayExecutionTime(System.nanoTime() - startTimeV4);
        //답표출
        System.out.println("네번째 답 : " + firstcharV4);

        System.out.println();

        //유니코드가 있다면?
        System.out.println("유니코드 문제 : " + TEXT_CP);
        System.out.println("자바8 함수형으로 해결");
        //시간체크 시작
        long startTimeV5 = System.nanoTime();
        //메서드
        String firstcharV5 = StringExt.firstNonRepeatedCharacterVCP4(TEXT_CP);
        //시간체크 끝
        displayExecutionTime(System.nanoTime() - startTimeV5);
        //답 표출
        System.out.println("다섯번째 답 : " + firstcharV5);
    }

    public static void displayExecutionTime(long time) {
        System.out.println("Execution time : " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
