import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Approach:
 * keep an index to keep track of pointer where to put the next value
 * */

public class MoveZeroestoEndOfArray {
    public static void moveZeroes(int[] nums) {
        int index = 0; //pointer to keep track of where to put the next value
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[index++] = nums[i];
            }
        }
        while(index < nums.length) {
            nums[index++] = 0;
        }
    }
    public  static void main(String[] args) {
        /*
        Example 1:

        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]
        Example 2:

        Input: nums = [0]
        Output: [0]
         */
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
