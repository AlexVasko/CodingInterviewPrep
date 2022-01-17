package datastructures.arrays.practice.slidingwindow;

public class ReplaceOnceMineTheir {
    public static int findLength(int[] arr, int k) {
        //[1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1]  k=2
        int windowStart = 0;
        int maxLength = 0;
        int countOfOnes = 0;
        for(int windowEnd = 0; windowEnd<arr.length; windowEnd++){
            if(arr[windowEnd]==1)
                countOfOnes++;

            if(windowEnd+1-windowStart - countOfOnes > k ){
                if(arr[windowStart]==1){
                    countOfOnes--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd+1-windowStart);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
