package Chapter01.P18_CheckTwoStringsAnagrams;

import javax.sound.midi.SysexMessage;
import java.util.concurrent.TimeUnit;

public class MainExt {

    private static final String TEXT1 = "hello world";
    private static final String TEXT2 = "dh\n le rlo l wo";
    private static long startTime = 0L;

    public static void main(String[] args) {
        System.out.println("두 문자열이 애너그램인지 검사\n");
        System.out.println("첫 번째 문자 : " + TEXT1);
        System.out.println("두 번째 문자 : " + TEXT2 + "\n");

        System.out.println("-------------------------------------------------");
        System.out.println("첫 번째 방법 : Arrays.sort() 이용");
        startTime = System.nanoTime();

        boolean anagramV1 = StringExt.isAnagramV1(TEXT1, TEXT2);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("아나그램이 맞습니까? " + anagramV1);
        System.out.println();

        System.out.println("-------------------------------------------------");
        System.out.println("두 번째 방법 : 자바8 함수형 이용");
        startTime = System.nanoTime();

        boolean anagramV2 = StringExt.isAnagramV2(TEXT1, TEXT2);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("아나그램이 맞습니까? " + anagramV2);
        System.out.println();

        System.out.println("-------------------------------------------------");
        System.out.println("세 번째 방법 : ASCII 코드 이용");
        startTime = System.nanoTime();

        boolean anagramV3 = StringExt.isAnagramV3(TEXT1, TEXT2);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("아나그램이 맞습니까? " + anagramV3);
        System.out.println();
    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
