package Chapter01.P05_CountVowelsAndConsonants;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public final class StringExt {
    private static final Set<Character> allVowels
            = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    private StringExt(){ throw new AssertionError("인스턴스가 될 수 없습니다."); }

    // Note: For Unicode supplementary characters use codePointAt() instead of charAt()
    //       and codePoints() instead of chars()
    //       Also, note that languages can have a different number of vowels and consonants
    //       (e.g., in Romanian there are 7 vowels: a, e, i, o, u, ă, î (â). Therefore,
    //       consider adjust the code accordingly.

    public static PairExt<Integer, Integer> countVowelsAndConsonantsV1(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return PairExt.of(-1, -1);
        }

        str = str.toLowerCase();

        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        return PairExt.of(vowels, consonants);
    }

    public static PairExt<Long, Long> countVowelsAndConsonantsV2(String str) {
        if (str == null || str.isEmpty()) {
            // or throw new IllegalArgumentException
            return PairExt.of(-1L, -1L);
        }

        str = str.toLowerCase();

        long vowels = str.chars()
                .filter(c -> allVowels.contains((char)c ))
                .count();
        long consonants = str.chars()
                .filter( c -> !allVowels.contains((char) c))
                .filter( c -> ('a' <= c && c <= 'z') )
                .count();

        return PairExt.of(vowels, consonants);
    }

    public static PairExt<Long, Long> countVowelsAndConsonantsV3(String str) {
        if (str == null || str.isEmpty()) {
            // or throw new IllegalArgumentException
            return PairExt.of(-1L, -1L);
        }

        str = str.toLowerCase();

        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> ('a' <= ch && ch <= 'z'))
                .collect(partitioningBy(c -> !allVowels.contains(c), counting()));

        return PairExt.of(result.get(false), result.get(true));
    }
}
