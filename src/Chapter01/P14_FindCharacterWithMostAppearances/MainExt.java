package Chapter01.P14_FindCharacterWithMostAppearances;

import java.util.concurrent.TimeUnit;

public class MainExt {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    public static void main(String[] args) {
        System.out.println("빈도수가 가장 많은 문자 찾기\n");
        System.out.println("입력 문자 : " + TEXT + "\n");

        System.out.println("-----------------------------------------");
        System.out.println("첫 번째 방법 : HashMap 이용");
        long startTime = System.nanoTime();

        PairExt pairV1 = StringExt.maxOccurenceCharacterV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("해당 문자 : " + pairV1.character);
        System.out.println("횟수 : " + pairV1.occurrences);
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("두 번째 방법 : ASCII 코드 이용");
        startTime = System.nanoTime();

        PairExt pairV2 = StringExt.maxOccurenceCharacterV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("해당 문자 : " + pairV2.character);
        System.out.println("횟수 : " + pairV2.occurrences);
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("세 번째 방법 : 자바8 함수형 스타일 이용");
        startTime = System.nanoTime();

        PairExt pairV3 = StringExt.maxOccurenceCharacterV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("해당 문자 : " + pairV3.character);
        System.out.println("횟수 : " + pairV3.occurrences);
        System.out.println();
    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
