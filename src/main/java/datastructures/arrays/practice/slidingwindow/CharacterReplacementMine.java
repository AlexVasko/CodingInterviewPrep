package datastructures.arrays.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;


//TODO: Look their solution. It is more efficient.
public class CharacterReplacementMine {
    //Input: String="aabcdbb", k=2
    //Output: 5
    //Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
    public static int findLength(String str, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        int maxCharCount = 0;
        char[] chArr = str.toCharArray();
        for (int windowEnd = 0; windowEnd < chArr.length; windowEnd++) {
            charCount.put(chArr[windowEnd], charCount.getOrDefault(chArr[windowEnd], 0) + 1);
            int count = charCount.get(chArr[windowEnd]);
            maxCharCount = Math.max(maxCharCount, count);

            while (windowEnd - windowStart + 1 - maxCharCount > k) {
                charCount.put(chArr[windowStart], charCount.get(chArr[windowStart]) - 1);
                if (charCount.get(chArr[windowStart]) == 0) {
                    charCount.remove(chArr[windowStart]);
                }
                maxCharCount = findMaxCount(charCount);
                windowStart++;
            }
            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
        }

        return maxLength;
    }

    private static int findMaxCount(Map<Character, Integer> charCount) {
        int max = 0;
        for (Integer i : charCount.values()) {
            if(i>max) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacementMine.findLength("aabccbb", 2));
        System.out.println(CharacterReplacementMine.findLength("abbcb", 1));
        System.out.println(CharacterReplacementMine.findLength("abccde", 1));
    }
}
