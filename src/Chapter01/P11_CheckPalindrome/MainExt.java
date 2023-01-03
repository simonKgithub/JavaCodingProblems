package Chapter01.P11_CheckPalindrome;

import java.util.concurrent.TimeUnit;

public class MainExt {

    private static final String TEXT = "ABCDEFEDCBA";
    private static final String TEXT_NOT_PALINDROME = "ABCDEF";

    public static void main(String[] args) {
        System.out.println("회문열 체크하기 \n");
        System.out.println("입력 문자 :");
        System.out.println("\t 회문열 : " + TEXT);
        System.out.println("\t 회문열 아님 : " + TEXT_NOT_PALINDROME + "\n");

        System.out.println("첫 번째 방법 : 중간에서 만나기(while 이용)");
        long startTimeV1 = System.nanoTime();

        boolean resultV11 = StringExt.isPalindromeV1(TEXT);
        boolean resultV12 = StringExt.isPalindromeV1(TEXT_NOT_PALINDROME);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("결과 : ");
        System.out.println("\t'" + TEXT + "' 는 회문열입니까? : " + resultV11);
        System.out.println("\t'" + TEXT_NOT_PALINDROME + "' 는 회문열입니까? : " + resultV12);
        System.out.println();

        System.out.println("두 번째 방법 : 중간에서 만나기(for 이용)");
        long startTimeV2 = System.nanoTime();

        boolean resultV21 = StringExt.isPalindromeV2(TEXT);
        boolean resultV22 = StringExt.isPalindromeV2(TEXT_NOT_PALINDROME);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("결과 : ");
        System.out.println("\t'" + TEXT + "' 는 회문열입니까? : " + resultV21);
        System.out.println("\t'" + TEXT_NOT_PALINDROME + "' 는 회문열입니까? : " + resultV22);
        System.out.println();

        System.out.println("세 번째 방법 : StringBuilder 이용");
        long startTimeV3 = System.nanoTime();

        boolean resultV31 = StringExt.isPalindromeV3(TEXT);
        boolean resultV32 = StringExt.isPalindromeV3(TEXT_NOT_PALINDROME);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("결과 : ");
        System.out.println("\t'" + TEXT + "' 는 회문열입니까? : " + resultV31);
        System.out.println("\t'" + TEXT_NOT_PALINDROME + "' 는 회문열입니까? : " + resultV32);
        System.out.println();

        System.out.println("네 번째 방법 : 자바8 함수형 스타일 이용");
        long startTimeV4 = System.nanoTime();

        boolean resultV41 = StringExt.isPalindromeV4(TEXT);
        boolean resultV42 = StringExt.isPalindromeV4(TEXT_NOT_PALINDROME);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("결과 : ");
        System.out.println("\t'" + TEXT + "' 는 회문열입니까? : " + resultV41);
        System.out.println("\t'" + TEXT_NOT_PALINDROME + "' 는 회문열입니까? : " + resultV42);
        System.out.println();

    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }


}
