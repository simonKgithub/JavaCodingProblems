package Chapter01.P05_CountVowelsAndConsonants;

import java.util.concurrent.TimeUnit;

public class MainExt {
    // 모음['a', 'e', 'i', 'o', 'u'] 14, 자음[나머지] 19
    private static final String TEXT = " ... Illinois Mathematics & Science Academy ... ";

    public static void main(String[] args) {
        System.out.println("모음 자음 세기");

        System.out.println("입력 문자 : \n" + TEXT);
        System.out.println();

        System.out.println("첫 번째 방법 : Stirng.charAt() ");
        long startTimeV1 = System.nanoTime();

        PairExt pairV1 = StringExt.countVowelsAndConsonantsV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("모음 : " + pairV1.vowels);
        System.out.println("자음 : " + pairV1.consonants);
        System.out.println();

        System.out.println("두 번째 방법 : 자바8 함수형 이용 ");
        long startTimeV2 = System.nanoTime();

        PairExt pairV2 = StringExt.countVowelsAndConsonantsV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("모음 : " + pairV2.vowels);
        System.out.println("자음 : " + pairV2.consonants);
        System.out.println();

        System.out.println("세 번째 방법 : 자바8 함수형 이용(partitioningBy) ");
        long startTimeV3 = System.nanoTime();

        PairExt pairV3 = StringExt.countVowelsAndConsonantsV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("모음 : " + pairV3.vowels);
        System.out.println("자음 : " + pairV3.consonants);
        System.out.println();

    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + "ms)");
    }
}
