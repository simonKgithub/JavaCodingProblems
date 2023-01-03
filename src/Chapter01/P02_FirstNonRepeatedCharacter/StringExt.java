package Chapter01.P02_FirstNonRepeatedCharacter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringExt {
    //http://www.alansofficespace.com/unicode/unicd99.htm
    private static final int EXTENDED_ASCII_CODES = 256; // can be increase to 65535

    //첫번째 방법
    public static char firstNonRepeatedCharacterV1(String str){

        if( str == null || str.isEmpty() ){
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if(ch == str.charAt(j) && i != j) {
                    count++;
                    break;
                }
            }

            if( count == 0){
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharacterV2(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        int[] flags = new int[EXTENDED_ASCII_CODES];

        //256의 문자들을 -1로 세팅
        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        // str : asd f ihusidhfiu
        // 4번째 f 차례라 하자
        // flags[f] = 3; 4번째 애다!!를 저장함
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flags[ch] == -1) {
                //첫번째 나온 애들은 ASCII 코드 내 decimal 번호를 부여
                // ex, M은 77 -> flag[77] 에 i를 넣음
                // flag[77] 은 ASCII 코드의 decimal 위치이므로 77 = M 을 의미
                flags[ch] = i; //위치
            } else {
                //2번 이상 나온 애들은 -2처리
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                // 양수인 애들 중 제일 첫번째 (바로 전 for문에서 i를 순서대로 부여했으므로)
                // 위치가 제일 빠른 애를 넣어줌
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    public static char firstNonRepeatedCharacterV3(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        Map<Character, Integer> chars = new LinkedHashMap<>();

        // or use for(char ch : str.toCharArray()){...}
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharacterV4(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        Map<Integer, Long> chs = str.chars()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        return (char) (int) chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));
    }

    public static String firstNonRepeatedCharacterVCP4(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return String.valueOf(Character.MIN_VALUE);
        }

        Map<Integer, Long> chs = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }
}
