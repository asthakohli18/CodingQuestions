import java.util.HashMap;
import java.util.Map;

/***
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */
public class MaxNumberOfPairsWithSumK {
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //map to contain the number and its count
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], (map.getOrDefault(nums[i], 0) + 1));
        }
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            if(map.containsKey(k-num) && map.get(k-num)>0) {
                map.put(k-num, map.get(k-num)-1);
                map.put(num, map.get(num)-1);
                if(map.get(num) >= 0 && map.get(k-num) >= 0)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /*
        Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

         */
        int[] nums = {1,2,3,4}; int k=5;
        System.out.println(maxOperations(nums,k));
    }
}
