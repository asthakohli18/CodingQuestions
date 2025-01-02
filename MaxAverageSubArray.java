/***
 * Sliding Window
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 */
public class MaxAverageSubArray {
    public static double findMaxAverage(int[] nums, int k) {
        int start=0; int end = 0;
        double maxSum = 0;
        double currentWindowSum = 0;
        while(end<nums.length) {
            if(end<k) {
                currentWindowSum = currentWindowSum+nums[end];
                end++;
                maxSum = currentWindowSum;
            } else {
                currentWindowSum=currentWindowSum-nums[start];
                start++;
                currentWindowSum = currentWindowSum+nums[end];
                end++;
                maxSum = Math.max(currentWindowSum, maxSum);
            }
        }
        return maxSum/k;
    }
    public static void main(String[] args) {
/*
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 */
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
