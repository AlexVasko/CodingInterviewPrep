package datastructures.arrays.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinctMy {

    public static final String LENGTH_OF_THE_LONGEST_SUBSTRING = "Length of the longest substring: ";

    public static int findLength(String str, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chArr = str.toCharArray();
        int windowStart = 0;
        int length = 0;
        for(int windowEnd=0; windowEnd<chArr.length; windowEnd++){
            charMap.put(chArr[windowEnd], charMap.getOrDefault(chArr[windowEnd],0)+1);
            while(charMap.size()>k){
                if(charMap.get(chArr[windowStart])>1){
                    charMap.put(chArr[windowStart], charMap.get(chArr[windowStart])-1);
                } else {
                    charMap.remove(chArr[windowStart]);
                }
                windowStart++;
            }
            if(length<windowEnd-windowStart+1){
                length = windowEnd - windowStart+1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(LENGTH_OF_THE_LONGEST_SUBSTRING + LongestSubstringKDistinctMy.findLength("araaci", 2));
        System.out.println(LENGTH_OF_THE_LONGEST_SUBSTRING + LongestSubstringKDistinctMy.findLength("araaci", 1));
        System.out.println(LENGTH_OF_THE_LONGEST_SUBSTRING + LongestSubstringKDistinctMy.findLength("cbbebi", 3));
    }

}
