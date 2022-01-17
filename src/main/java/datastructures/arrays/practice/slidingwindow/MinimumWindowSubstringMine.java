package datastructures.arrays.practice.slidingwindow;

import java.util.*;

class MinimumWindowSubstringMine {
    public static String findSubstring(String str, String pattern) {
        String smallestSubstring = "";
        Map<Character, Integer> pMap = new HashMap<>();
        for (Character c : pattern.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int foundCount = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character endKey = str.charAt(windowEnd);
            if (pMap.containsKey(endKey)) {
                pMap.put(endKey, pMap.get(endKey) - 1);

                if (pMap.get(endKey) == 0) {
                    foundCount++;
                }
            }

            if (foundCount == pMap.size() && windowEnd + 1 - windowStart <= minLength) {
                minLength = windowEnd + 1 - windowStart;
                smallestSubstring = str.substring(windowStart, windowEnd + 1);
            }

            while (foundCount == pMap.size() && windowEnd + 1 - windowStart > pattern.length()) {
                Character startKey = str.charAt(windowStart);
                windowStart++;
                if (pMap.containsKey(startKey)) {
                    pMap.put(startKey, pMap.get(startKey) + 1);
                }
                if (pMap.get(startKey) == null || pMap.get(startKey) == 0) {
                    minLength = windowEnd - windowStart + 1;
                    smallestSubstring = str.substring(windowStart, windowEnd + 1);
                }
                if (pMap.get(startKey) != null && pMap.get(startKey) > 0) {
                    foundCount--;
                }


            }
        }
        return smallestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("adbadc", "abc"));
    }
}


