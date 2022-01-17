package datastructures.arrays.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//TODO: Look their solution. It is more efficient. This solution is supposed to use sliding window pattern, but it is not.
public class StringPermutationMine {
    public static boolean findPermutation(String str, String pattern) {
        //findPermutation(oidbcaf, abc)
        Map<Character, Integer> chPatternMap;
        char[] pArr = pattern.toCharArray();
        char[] sArr = str.toCharArray();
        boolean containsPerMutation = false;
        boolean resetMAp = false;
        chPatternMap = resetMap(pArr);
        for (char c : sArr) {
            if (chPatternMap.containsKey(c)) {
                chPatternMap.put(c, chPatternMap.get(c) - 1);
                resetMAp = true;
                if (chPatternMap.get(c) == 0) {
                    chPatternMap.remove(c);
                    if (chPatternMap.isEmpty()) {
                        containsPerMutation = true;
                        break;
                    }
                }
            } else {
                if(resetMAp)
                    chPatternMap = resetMap(pArr);
            }
        }
        return containsPerMutation;
    }

    static Map<Character, Integer> resetMap(char[] cArr) {
        Map<Character, Integer> chPatternMap = new HashMap<>();
        for (char c : cArr) {
            chPatternMap.put(c, chPatternMap.getOrDefault(c, 0) + 1);
        }
        return chPatternMap;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
    }
}
