package Chapter01.P06_CountOccurrencesOfCharacter;

import java.util.concurrent.TimeUnit;

public class MainExt {
    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";
    private static final char CHAR_TO_COUNT = 'u';

    private static final String TEXT_CP = "π I love π you Σ so much π π";
    private static final String CHAR_TO_COUNT_CP = "Σ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_TO_COUNT_CPS = "π"; // Unicode: \uD83D\uDC95, Code Point: 128149

    public static void main(String[] args) {
        System.out.println("λ¬Έμ₯μ ν¬ν¨λ λ¬Έμ μΈκΈ°");

        System.out.println("μλ ₯ λ¬Έμ : \n" + TEXT + "\n");

        System.out.println("=========================================================================");
        System.out.println("μμ€ν€(ASCII) λλ 16 λΉνΈ μ λμ½λ λ¬Έμ (65,535 (0xFFFF) μ΄ν) μΌ λ νμ΄λ² \n");

        System.out.println("μ²« λ²μ§Έ λ°©λ² : replace() μ΄μ©");
        long startTimeV1 = System.nanoTime();

        int countV1 = StringExt.countOccurrencesOfACertainCharacterV1(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT + "'\nλ°μ νμ : " + countV1);
        System.out.println();

        System.out.println("λ λ²μ§Έ λ°©λ² : charAt() μ΄μ©");
        long startTimeV2 = System.nanoTime();

        int countV2 = StringExt.countOccurrencesOfACertainCharacterV2(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT + "'\nλ°μ νμ : " + countV2);
        System.out.println();

        System.out.println("μΈ λ²μ§Έ λ°©λ² : μλ°8 ν¨μν μ΄μ©");
        long startTimeV3 = System.nanoTime();

        long countV3 = StringExt.countOccurrencesOfACertainCharacterV3(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT + "'\nλ°μ νμ : " + countV3);
        System.out.println();

        System.out.println("=========================================================================");
        System.out.println("Unicode surrogate pairs(UTF-16 κ³Ό UTF-32 μ¬μκ°μ΄ μ‘΄μ¬ν  λ) νμ΄λ² \n");
        System.out.println("μλ ₯ λ¬Έμ : \n" + TEXT_CP + "\n");

        System.out.println("λ€ λ²μ§Έ λ°©λ²(μ²« λ²μ§Έ λ°©λ²μ μ°μ₯) : replace() μ΄μ©");
        long startTimeV4 = System.nanoTime();

        int countV4 = StringExt.countOccurrencesOfACertainCharacterVCP1(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT_CP + "'\nλ°μ νμ : " + countV4);
        System.out.println();

        long startTimeV5 = System.nanoTime();

        int countV5 = StringExt.countOccurrencesOfACertainCharacterVCP1(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV5);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT_CPS + "'\nλ°μ νμ : " + countV5);
        System.out.println();

        System.out.println("λ€μ― λ²μ§Έ λ°©λ²(λ λ²μ§Έ λ°©λ²μ μ°μ₯) : codePointAt() μ΄μ©");
        long startTimeV6 = System.nanoTime();

        int countV6 = StringExt.countOccurrencesOfACertainCharacterVCP2(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV6);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT_CP + "'\nλ°μ νμ : " + countV6);
        System.out.println();

        long startTimeV7 = System.nanoTime();

        int countV7 = StringExt.countOccurrencesOfACertainCharacterVCP2(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV7);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT_CPS + "'\nλ°μ νμ : " + countV7);
        System.out.println();

        System.out.println("μ¬μ― λ²μ§Έ λ°©λ²(μΈ λ²μ§Έ λ°©λ²μ μ°μ₯) : μλ°8 ν¨μν μ΄μ©");
        long startTimeV8 = System.nanoTime();

        long countV8 = StringExt.countOccurrencesOfACertainCharacterVCP3(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV8);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT_CP + "'\nλ°μ νμ : " + countV8);
        System.out.println();

        long startTimeV9 = System.nanoTime();

        long countV9 = StringExt.countOccurrencesOfACertainCharacterVCP3(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV9);
        System.out.println("λ¬Έμ : '" + CHAR_TO_COUNT_CPS + "'\nλ°μ νμ : " + countV9);
        System.out.println();

    }

    private static void displayExecutionTime(long time) {
        System.out.println("μ€ν μκ° : " + time + " ns ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
