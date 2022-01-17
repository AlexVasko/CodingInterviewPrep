package datastructures.arrays.practice.slidingwindow;

import java.util.*;


//TODO: Couldn't solve it on my own. Has to Be revised in the future.
class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int windowStart = 0;
        int foundCount = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char charRight = str.charAt(windowEnd);
            if (charMap.containsKey(charRight)) {
                charMap.put(charRight, charMap.get(charRight) - 1);
                if (charMap.get(charRight) == 0) {
                    foundCount++;
                }

            }
            if (foundCount == charMap.size()) {
                resultIndices.add(windowStart);
            }
            if (windowEnd >= pattern.length() - 1) {
                char charLeft = str.charAt(windowStart++);
                if (charMap.containsKey(charLeft)) {
                    if (charMap.get(charLeft) == 0) {
                        foundCount--;
                    }
                    charMap.put(charLeft, charMap.getOrDefault(charLeft, 0) + 1);
                }
            }


        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findStringAnagrams("abbcabc", "abc"));
        System.out.println(findStringAnagrams("ppqp", "pq"));
    }
}
