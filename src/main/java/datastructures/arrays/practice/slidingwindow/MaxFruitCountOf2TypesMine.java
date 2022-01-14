package datastructures.arrays.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2TypesMine {
    private static final int limit = 2;

    public static int findLength(char[] arr) {
        Map<Character, Integer> fruitMap = new HashMap<>();
        int windowStart = 0;
        int maxFruits = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitMap.put(arr[windowEnd], fruitMap.getOrDefault(arr[windowEnd], 0) + 1);

            while (fruitMap.size() > limit) {
                fruitMap.put(arr[windowStart], fruitMap.get(arr[windowStart]) - 1);
                if (fruitMap.get(arr[windowStart]) == 0) {
                    fruitMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);

        }

        return maxFruits;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " +
                findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
