package datastructures.arrays.practice.slidingwindow;


import java.util.*;
public class StringAnagrams2ndTry {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for(Character c: pattern.toCharArray()){
            pMap.put(c, pMap.getOrDefault(c,0)+1);
        }
        int foundCount = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd<str.length(); windowEnd++){
            Character c = str.charAt(windowEnd);
            if(pMap.containsKey(c)){
                pMap.put(c, pMap.get(c)-1);
                if(pMap.get(c)==0){

                    foundCount++;
                }
            }
            if(foundCount== pMap.size()){
                resultIndices.add(windowStart);
            }

            if(windowEnd - windowStart + 1 >= pattern.length()){
                pMap.put(str.charAt(windowStart), pMap.getOrDefault(str.charAt(windowStart),0)+1);
                if(pMap.get(str.charAt(windowStart))>0){
                    foundCount--;
                }
                windowStart++;
            }
        }


        return resultIndices;
    }
}
