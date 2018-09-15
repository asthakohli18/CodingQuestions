import java.util.ArrayList;
import java.util.List;

/**
 * Created by kohas02 on 7/5/18.
 */
public class ArrayUtils{


    private int largestSumContigousArr(int[] arr){
        int maxSum =arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++){

            if(arr[i] > arr[i]+maxSum ){
                maxSum = arr[i];
            }
            else {
                maxSum = arr[i]+maxSum;
            }

            System.out.print(" "+maxSum);
            max = Math.max(max,maxSum);
        }
        return max;
    }


    private int lengthOfLargestSubArraywithAtmostValueofK(int k, int[] arr){
        int count = 0;
        int maxCount=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){

            if(sum+arr[i] < k){
                sum = sum+arr[i];
                count++;
            }
            else if(sum!=0){
                 sum = sum-arr[i-count]+arr[i];
            }

            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }

    private int numOfSubArraysProductLessThanK(int[] arr, int k){
        int prod = 1;
        int numberOfSubArrays=0;
        int left=0;
        if(k<=1)
            return 0;
        for(int right=0;right<arr.length;right++){
            prod=prod*arr[right];
            while(prod>k){
                prod=prod/arr[left++];
            }
            numberOfSubArrays=numberOfSubArrays + (right-left+1);
            /**
             * Note :
             * right-left+1 -> this adds the new subarrays that will be created by addition of one more number tot subarray
             * */
        }
        return numberOfSubArrays;
    }

    /**
     * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
     * such that all elements of the subsequence are sorted in increasing order.
     * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
     *
     * Input : arr[] = {50, 3, 10, 7, 40, 80}
     * Output : Length of LIS = 4
     * The longest increasing subsequence is {3, 7, 40, 80}
     *
     * then, L(i) can be recursively written as:
     L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
     L(i) = 1, if no such j exists.
     *
     * Global variable : maxLengthOverall
     *
     * */
    private static int maxLengthOverall = 1; //global variable

    private int LIS(int[] arr, int n){

        int maxLengthAtPrevIndex = 1;
        int maxLengthAtCurrIndex =1;
        for(int i=1;i<n;i++){
            maxLengthAtPrevIndex = LIS(arr, i); //till that index what is the max
            if((arr[i]>arr[i-1]) && maxLengthAtPrevIndex+1>maxLengthAtCurrIndex){
                maxLengthAtCurrIndex = maxLengthAtPrevIndex+1;
            }
        }
        if(maxLengthOverall<maxLengthAtCurrIndex){
            maxLengthOverall = maxLengthAtCurrIndex;
        }

        return maxLengthAtCurrIndex;
    }

    /**
     * Print all subsets of given size of a set
     *
     * Input  : arr[] = {1, 2, 3, 4}
     r = 2
     Output :  1 2
     1 3
     1 4
     2 3
     2 4
     3 4

     Input  : arr[] = {10, 20, 30, 40, 50}
     r = 3
     Output : 10 20 30
     10 20 40
     10 20 50
     10 30 40
     10 30 50
     10 40 50
     20 30 40
     20 30 50
     20 40 50
     30 40 50

     * */

    static List<int[]> listOfSubArrays = new ArrayList<>();
    private static void printCombination(int[] arr, int n, int r){
        int[] data = new int[r];


        printCombinationHelper(arr, n , r , data, 0, 0);
    }

    private static void printCombinationHelper(int[] arr, int n, int r, int[] data, int indexInSubArray, int indexInMainArray) {
        if(indexInSubArray == r) {
            //print the subarray
            for (int j = 0; j < r; j++){
                System.out.print(data[j] + " ");
                listOfSubArrays.add(data);
            }
            System.out.println("");
            return;
        }

        // When no more elements are there to put in data[]
        if(indexInMainArray>=n)
            return;

        data[indexInSubArray] = arr[indexInMainArray];
        printCombinationHelper(arr, n, r, data, indexInSubArray+1, indexInMainArray+1);

        printCombinationHelper(arr, n, r, data, indexInSubArray, indexInMainArray+1);
    }


    public static void main(String args[]){
        ArrayUtils obj = new ArrayUtils();
        System.out.println("\nLargest subarray contigous sum ="+ obj.largestSumContigousArr(new int[]{-2,-3,4,-1,-2,1,5,-3}));

        System.out.println("\nlength Of Largest SubArray with Atmost Value of K ="+obj.lengthOfLargestSubArraywithAtmostValueofK(4, new int[]{1, 2, 1, 0, 1, 1, 0}));

        System.out.println("\nnumber Of SubArrays wherein the product of values in subarrays < 50 = "+obj.numOfSubArraysProductLessThanK(new int[]{3, 4, 5},50));

        obj.LIS(new int[]{50, 3, 10, 7, 40, 80},6);
        System.out.println("\nlength of Longest Increasing Subsequence (LIS) from the given array = "+ maxLengthOverall);

        System.out.println("\nPrint all combinations of subarrays of size 3\n");
        printCombination(new int[]{10,20,30,40,50},5,3);


    }

}
