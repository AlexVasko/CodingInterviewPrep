package datastructures.arrays.practice.slidingwindow;

public class SmallestSubarrayGreaterSumMy {


    public static void main(String[] args) {
        int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }

    public static int findMinSubArray(int S, int[] arr) {
        int sum = 0;
        int minLength = 0;
        int windowStart = 0;
        int windowEnd = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= S) {
                sum -= arr[windowStart];
                if (minLength > 0) {
                    minLength = Math.min(minLength, (windowEnd - windowStart));
                } else {
                    minLength = windowEnd - windowStart;
                }
                windowStart++;
            }
            windowEnd++;
        }
        return minLength;
    }
}
