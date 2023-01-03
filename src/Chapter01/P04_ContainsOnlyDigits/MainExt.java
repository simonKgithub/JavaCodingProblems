package Chapter01.P04_ContainsOnlyDigits;

import java.util.concurrent.TimeUnit;

public class MainExt {

    private static final String ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326";

    private static final String NOT_ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326A";

    public static void main(String[] args) {
        System.out.println("숫자만 있는 경우 : \n" + ONLY_DIGITS);
        System.out.println("다른 문자 포함된 경우 : \n" + NOT_ONLY_DIGITS);
        System.out.println();

        System.out.println("첫 번째 방법 : Character.isDigit() 메서드 사용 ");
        long startTimeV1 = System.nanoTime();

        boolean onlyDigitsV11 = StringExt.containOnlyDigitsV1(ONLY_DIGITS);
        boolean onlyDigitsV12 = StringExt.containOnlyDigitsV1(NOT_ONLY_DIGITS);

        displayExecutionTime(System.nanoTime() - startTimeV1);

        System.out.println("숫자만 있는 경우 : " + onlyDigitsV11);
        System.out.println("다른 문자 포함된 경우 : " + onlyDigitsV12);

        System.out.println();

        System.out.println("두 번째 방법 : String.matches() 사용 : ");
        long startTimeV2 = System.nanoTime();

        boolean onlyDigitsV21 = StringExt.containOnlyDigitsV2(ONLY_DIGITS);
        boolean onlyDigitsV22 = StringExt.containOnlyDigitsV2(NOT_ONLY_DIGITS);

        displayExecutionTime(System.nanoTime() - startTimeV2);

        System.out.println("숫자만 있는 경우 : " + onlyDigitsV21);
        System.out.println("다른 문자 포함된 경우 : " + onlyDigitsV22);

        System.out.println();

        System.out.println("세 번째 방법 : 자바8 함수형 사용 : ");
        long startTimeV3 = System.nanoTime();

        boolean onlyDigitsV31 = StringExt.containOnlyDigitsV3(ONLY_DIGITS);
        boolean onlyDigitsV32 = StringExt.containOnlyDigitsV3(NOT_ONLY_DIGITS);

        displayExecutionTime(System.nanoTime() - startTimeV3);

        System.out.println("숫자만 있는 경우 : " + onlyDigitsV31);
        System.out.println("다른 문자 포함된 경우 : " + onlyDigitsV32);

        System.out.println();


        System.out.println("네 번째 방법 : 자바8 함수형 사용 : ");
        long startTimeV4 = System.nanoTime();

        boolean onlyDigitsV41 = StringExt.containOnlyDigitsV4(ONLY_DIGITS);
        boolean onlyDigitsV42 = StringExt.containOnlyDigitsV4(NOT_ONLY_DIGITS);

        displayExecutionTime(System.nanoTime() - startTimeV4);

        System.out.println("숫자만 있는 경우 : " + onlyDigitsV41);
        System.out.println("다른 문자 포함된 경우 : " + onlyDigitsV42);

        System.out.println();
    }

    public static void displayExecutionTime(long time) {
        System.out.println("실행시간 : " + time + " ns ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
