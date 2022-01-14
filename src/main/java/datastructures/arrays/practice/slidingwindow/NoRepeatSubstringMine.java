package datastructures.arrays.practice.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstringMine {

    public static int findLength(String str) {
        Set<Character> chSet = new HashSet<>();
        char[] chArr = str.toCharArray();
        int windowStart = 0;
        int maxLength = 0;
        for(int windowEnd = 0; windowEnd<chArr.length; windowEnd++){
            if(!chSet.contains(chArr[windowEnd])){
                chSet.add(chArr[windowEnd]);
            } else {
                while(chSet.contains(chArr[windowEnd])){
                    chSet.remove(chArr[windowStart]);
                    windowStart++;
                }
                chSet.add(chArr[windowEnd]);
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + findLength("abbbb"));
        System.out.println("Length of the longest substring: " + findLength("abccde"));
    }
}
