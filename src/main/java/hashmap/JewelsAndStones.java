package hashmap;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStones {

    public static void main(String... args) {
        int count = numJewelsInStones("aA", "aAaBc");

        Assertions.assertTrue(count == 3);
    }

    private static int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length();i++) {
            set.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length();i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}
