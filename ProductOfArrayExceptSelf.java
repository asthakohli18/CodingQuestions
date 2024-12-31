import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int prod = 1;int countZero = 0;
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                prod = prod*nums[i];
            } else {
                countZero++;
            }
        }
        for(int i=0;i<nums.length;i++ ) {
            if(countZero>1) {
                result[i] = 0;
            }
            else if(countZero>0 && countZero<=1 && nums[i] == 0) {
                result[i] = prod;
            } else if(countZero>0 && nums[i]!=0) {
                result[i] = 0;
            } else if(countZero==0) {
                result[i] = prod/nums[i];
            }

        }
        return result;
    }
    public static void main(String[] args) {
        /*
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]

         */
        int[] arr = {-1,1,0,-3,3};
        int[] result = productExceptSelf(arr);
        System.out.println(Arrays.toString(result));
    }
}
