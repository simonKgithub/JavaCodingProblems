package Chapter01.P16_CheckStringContainsSubstring;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainExt {

    private static long startTime = 0;

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    private static final String SUBTEXT = "programmer";

    public static void main(String[] args) {
        System.out.println("문자열이 부분 문자열을 포함하는지 검사\n");
        System.out.println("입력 문자 : \n" + TEXT + "\n");
        System.out.println("찾을 문자 : " + SUBTEXT + "\n");

        System.out.println("-----------------------------------------");
        System.out.println("첫 번째 방법 : String.contains() 이용");

        startTime = System.nanoTime();

        boolean containsV1 = TEXT.contains(SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTime);

        System.out.println("- 결과(포함되었나?) : " + containsV1);
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("두 번째 방법 : 정규식 이용");

        startTime = System.nanoTime();

        boolean containsV2 = StringExt.containsV2(TEXT,SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTime);

        System.out.println("- 결과(포함되었나?) : " + containsV2);
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("세 번째 방법 : String.indexOf() 이용");

        startTime = System.nanoTime();

        boolean containsV3 = StringExt.containsV3(TEXT,SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTime);

        System.out.println("- 결과(포함되었나?) : " + containsV3);
        System.out.println();
    }

    private static void displayExecutionTime(long time) {
        System.out.println("- 실행시간: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
