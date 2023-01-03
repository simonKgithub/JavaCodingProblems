package Chapter01.P08_RemoveWhitespacesFromString;

import java.util.concurrent.TimeUnit;

public class MainExt {

    private static final String TEXT = "      My high\n\n school,        the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. \r"
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, \t"
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.           ";

    public static void main(String[] args) {
        System.out.println("공백 없애기");
        System.out.println("입력 문자 : \n" + TEXT);

        System.out.println("첫 번째 방법 : replaceAll() 이용");

        long startTime = System.nanoTime();

        String result = StringExt.removeWhitespaces(TEXT);

        displayExecutionTime(System.nanoTime() - startTime);

        System.out.println("결과 : \n" + result);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
