package Chapter01.P06_CountOccurrencesOfCharacter;

import java.util.concurrent.TimeUnit;

public class MainExt {
    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";
    private static final char CHAR_TO_COUNT = 'u';

    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
    private static final String CHAR_TO_COUNT_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_TO_COUNT_CPS = "💕"; // Unicode: \uD83D\uDC95, Code Point: 128149

    public static void main(String[] args) {
        System.out.println("문장에 포함된 문자 세기");

        System.out.println("입력 문자 : \n" + TEXT + "\n");

        System.out.println("=========================================================================");
        System.out.println("아스키(ASCII) 또는 16 비트 유니코드 문자 (65,535 (0xFFFF) 이하) 일 때 풀이법 \n");

        System.out.println("첫 번째 방법 : replace() 이용");
        long startTimeV1 = System.nanoTime();

        int countV1 = StringExt.countOccurrencesOfACertainCharacterV1(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("문자 : '" + CHAR_TO_COUNT + "'\n발생 횟수 : " + countV1);
        System.out.println();

        System.out.println("두 번째 방법 : charAt() 이용");
        long startTimeV2 = System.nanoTime();

        int countV2 = StringExt.countOccurrencesOfACertainCharacterV2(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("문자 : '" + CHAR_TO_COUNT + "'\n발생 횟수 : " + countV2);
        System.out.println();

        System.out.println("세 번째 방법 : 자바8 함수형 이용");
        long startTimeV3 = System.nanoTime();

        long countV3 = StringExt.countOccurrencesOfACertainCharacterV3(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("문자 : '" + CHAR_TO_COUNT + "'\n발생 횟수 : " + countV3);
        System.out.println();

        System.out.println("=========================================================================");
        System.out.println("Unicode surrogate pairs(UTF-16 과 UTF-32 사잇값이 존재할 때) 풀이법 \n");
        System.out.println("입력 문자 : \n" + TEXT_CP + "\n");

        System.out.println("네 번째 방법(첫 번째 방법의 연장) : replace() 이용");
        long startTimeV4 = System.nanoTime();

        int countV4 = StringExt.countOccurrencesOfACertainCharacterVCP1(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("문자 : '" + CHAR_TO_COUNT_CP + "'\n발생 횟수 : " + countV4);
        System.out.println();

        long startTimeV5 = System.nanoTime();

        int countV5 = StringExt.countOccurrencesOfACertainCharacterVCP1(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV5);
        System.out.println("문자 : '" + CHAR_TO_COUNT_CPS + "'\n발생 횟수 : " + countV5);
        System.out.println();

        System.out.println("다섯 번째 방법(두 번째 방법의 연장) : codePointAt() 이용");
        long startTimeV6 = System.nanoTime();

        int countV6 = StringExt.countOccurrencesOfACertainCharacterVCP2(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV6);
        System.out.println("문자 : '" + CHAR_TO_COUNT_CP + "'\n발생 횟수 : " + countV6);
        System.out.println();

        long startTimeV7 = System.nanoTime();

        int countV7 = StringExt.countOccurrencesOfACertainCharacterVCP2(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV7);
        System.out.println("문자 : '" + CHAR_TO_COUNT_CPS + "'\n발생 횟수 : " + countV7);
        System.out.println();

        System.out.println("여섯 번째 방법(세 번째 방법의 연장) : 자바8 함수형 이용");
        long startTimeV8 = System.nanoTime();

        long countV8 = StringExt.countOccurrencesOfACertainCharacterVCP3(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV8);
        System.out.println("문자 : '" + CHAR_TO_COUNT_CP + "'\n발생 횟수 : " + countV8);
        System.out.println();

        long startTimeV9 = System.nanoTime();

        long countV9 = StringExt.countOccurrencesOfACertainCharacterVCP3(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV9);
        System.out.println("문자 : '" + CHAR_TO_COUNT_CPS + "'\n발생 횟수 : " + countV9);
        System.out.println();

    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
