/**
 * Created by kohas02 on 9/15/18.
 */
public class ArrayRotation {

    /**
     *
     * helper method for greatest common divisor of two numbers
     *
     * */
    int gcd(int a, int b){
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    /**
     * function that rotates arr[] of size n by d elements.
     * reference : geeksforgeeks
     * METHOD 3 (A Juggling Algorithm)
     *
     *
     * This is an extension of method 2. Instead of moving one by one, divide the array in different sets
     where number of sets is equal to GCD of n and d and move the elements within sets.
     *
     * ex arr : 1,2,3,4,5,6,7,8,9,10,11,12
     * n = 12
     * d = 3 (rotate by 3 elements)
     * GCD -> 4 (basically 4 sets)
     *
     * Time complexity : O(n)
     * Auxiliary Space : O(1)
     *
     * */
    private int[] leftRotateArray(int[] arr, int d, int n){

        //we need 4 times to iterate d digits amoungst the sets

        //actually moving blocks of 3 for 4times; which will lead to answer
        for(int i=0;i<gcd(n,d);i++){
            int temp = arr[i];
            int setStart=i;

            while(true) {
                int setEnd = setStart + d;
                if(setEnd >=n )
                   setEnd=setEnd-n;

                if(setEnd==i)
                    break;

                arr[setStart] =arr[setEnd];
                setStart=setEnd;
            }
            arr[setStart]=temp;

        }
        return arr;

    }

    public static void main(String args[]){
        ArrayRotation obj = new ArrayRotation();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] arr1 = obj.leftRotateArray(arr,3,12);
        for(int i=0;i<arr1.length;i++){
            System.out.print(" "+arr1[i]);
        }
    }
}
