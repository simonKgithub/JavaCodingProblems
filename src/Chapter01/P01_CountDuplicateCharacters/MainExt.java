package Chapter01.P01_CountDuplicateCharacters;

import java.util.Arrays;
import java.util.Map;

public class MainExt {
    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";

    // Σ -> Unicode: \u04DC, Code Point: 1244
    // π -> Unicode: \uD83D\uDC95, Code Point: 128149
    // πΌ -> \uD83C\uDFBC, Code Point: 127932
    // π ->\uD83D\uDE0D, Code Point: 128525
    private static final String TEXT_CP = TEXT + "π I love π you Σ so much π π πΌπΌπΌ!";

    public static void main(String[] args) {
        System.out.println("001. λ¬Έμ κ°μ μΈκΈ°");
        System.out.println("Input text : " + TEXT);

        System.out.println("Solution 1 : ");
        Map<Character, Integer> sol1 = StringExt.countDuplicateCharactersV1(TEXT);

        System.out.println(Arrays.toString(sol1.entrySet().toArray()));

        System.out.println();
        System.out.println("Solution 2 :");
        Map<Character, Long> sol2 = StringExt.countDuplicateCharactersV2(TEXT);

        System.out.println(Arrays.toString(sol2.entrySet().toArray()));


        System.out.println("001. λ¬Έμ κ°μ μΈκΈ°");
        System.out.println("Input text : " + TEXT_CP);

        System.out.println("Solution 3 : ");
        Map<String, Integer> sol3 = StringExt.countDuplicateCharactersVCP1(TEXT_CP);

        System.out.println(Arrays.toString(sol3.entrySet().toArray()));

        System.out.println();
        System.out.println("Solution 4 :");
        Map<String, Long> sol4 = StringExt.countDuplicateCharactersVCP2(TEXT_CP);

        System.out.println(Arrays.toString(sol4.entrySet().toArray()));
    }


}
