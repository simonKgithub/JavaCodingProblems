package Chapter01.P03_ReverseWords;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MainExt {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    public static void main(String[] args) {
        System.out.println("003. 글자와 단어 뒤집기");
        System.out.println("입력 문자 : ");
        System.out.println(TEXT);
        System.out.println();

        //첫 번째 방법
        System.out.println("첫 번째 방법 : StringBuilder 이용");
        //시간 시작
        long startTimeV1 = System.nanoTime();
        //메서드
        String reversedV1 = StringExt.reverseWordsV1(TEXT);
        //시간 끝
        displayExecutionTime(System.nanoTime() - startTimeV1);
        //답 표출
        System.out.println("첫 번째 답 : " + reversedV1);

        System.out.println();

        //두 번째 방법
        System.out.println("두 번째 방법 : 자바8 함수형 이용");
        //시간 시작
        long startTimeV2 = System.nanoTime();
        //메서드
        String reversedV2 = StringExt.reverseWordsV2(TEXT);
        //시간 끝
        displayExecutionTime(System.nanoTime() - startTimeV2);
        //답 표출
        System.out.println("두 번째 답 : " + reversedV2);

        System.out.println();

        //세 번째 방법
        System.out.println("세 번째 방법 : StringBuilder 이용 (단어별로가 아니라 아예 뒤집기)");
        //시간 시작
        long startTimeV3 = System.nanoTime();
        //메서드
        String reversedV3 = StringExt.reverse(TEXT);
        //시간 끝
        displayExecutionTime(System.nanoTime() - startTimeV3);
        //답 표출
        System.out.println("세 번째 답 : " + reversedV3);

        System.out.println();
    }

    private static void displayExecutionTime(long time){
        System.out.println("실행 시간 : " + time + " ns ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + "ms)");
    }

}
