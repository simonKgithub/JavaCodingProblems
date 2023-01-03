package Chapter01.P14_FindCharacterWithMostAppearances;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StringExt {

    private static final int EXTENDED_ASCII_CODES = 256;

    private StringExt(){throw new AssertionError("인스턴스화 되지 않음");}

    public static PairExt<Character, Integer> maxOccurenceCharacterV1(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return PairExt.of(Character.MAX_VALUE, -1);
        }

        Map<Character, Integer> counter = new HashMap<>();
        char[] chArr = str.toCharArray();
        for (char ch : chArr) {
            if (!Character.isWhitespace(ch)) { // ignore spaces
                Integer noCh = counter.get(ch);
                if (noCh == null) {
                    counter.put(ch, 1);
                } else {
                    counter.put(ch, ++noCh);
                }
            }
        }

        int maxOccurrences = Collections.max(counter.values());

        char maxCharacter = Character.MIN_VALUE;
        for ( Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == maxOccurrences) {
                maxCharacter = entry.getKey();
            }
        }

        return PairExt.of(maxCharacter, maxOccurrences);
    }

    public static PairExt<Character, Integer> maxOccurenceCharacterV2(String str) {
        if (str == null || str.isEmpty()) {
            return PairExt.of(Character.MIN_VALUE, -1);
        }

        int maxOccurrences = -1;
        char maxCharacter = Character.MIN_VALUE;

        char[] chArr = str.toCharArray();
        int[] asciiCodes = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < chArr.length; i++) {
            char currentCh = chArr[i];
            if ( !(Character.isWhitespace(currentCh)) ) {
                int code = (int) currentCh;
                asciiCodes[code]++;
                if (asciiCodes[code] > maxOccurrences) {
                    maxOccurrences = asciiCodes[code];
                    maxCharacter = currentCh;
                }
            }
        }

        return PairExt.of(maxCharacter, maxOccurrences);
    }

    public static PairExt<Character, Long> maxOccurenceCharacterV3(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return PairExt.of(Character.MIN_VALUE, -1L);
        }

        return str.chars()
                .filter(c -> Character.isWhitespace(c) == false) //ignore space
                .mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(p -> PairExt.of(p.getKey(), p.getValue()))
                .orElse(PairExt.of(Character.MIN_VALUE, -1L));
    }
}
