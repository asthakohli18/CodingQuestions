/**
 * Longest Subarray of 1's After Deleting One Element
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 */
public class LongestSubArrayOfOnes {
    public static int longestSubarray(int[] nums) {
        int left =0;
        int maxcount = 0;
        int zerocount = 0;
        for(int right = 0;right<nums.length;right++) {
            if(nums[right] == 0) {
                zerocount++;
            }
            while(zerocount>1) {
                if(nums[left]==0) {
                    zerocount--;
                }
                left++;
            }
            maxcount = Math.max(maxcount,right-left);
        }
        return maxcount;
    }
    public static void main(String[] args) {
        /*
        Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
         */
        int[] nums = {1,1,0,1};
        System.out.println(LongestSubArrayOfOnes.longestSubarray(nums));
    }
}
