package Chapter01.P01_CountDuplicateCharacters;

import java.util.Arrays;
import java.util.Map;

public class MainExt {
    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";

    // Ӝ -> Unicode: \u04DC, Code Point: 1244
    // 💕 -> Unicode: \uD83D\uDC95, Code Point: 128149
    // 🎼 -> \uD83C\uDFBC, Code Point: 127932
    // 😍 ->\uD83D\uDE0D, Code Point: 128525
    private static final String TEXT_CP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) {
        System.out.println("001. 문자 개수 세기");
        System.out.println("Input text : " + TEXT);

        System.out.println("Solution 1 : ");
        Map<Character, Integer> sol1 = StringExt.countDuplicateCharactersV1(TEXT);

        System.out.println(Arrays.toString(sol1.entrySet().toArray()));

        System.out.println();
        System.out.println("Solution 2 :");
        Map<Character, Long> sol2 = StringExt.countDuplicateCharactersV2(TEXT);

        System.out.println(Arrays.toString(sol2.entrySet().toArray()));


        System.out.println("001. 문자 개수 세기");
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
