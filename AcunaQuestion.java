/*
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by kohas02 on 7/29/18.
 *//*

public class AcunaQuestion {

    public static int  numSubarrayProductLessThanK(int[] arr, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < arr.length; right++) {
            prod *= arr[right];
            while (prod >= k) prod /= arr[left++];
            ans += right - left + 1;
        }
        return ans;
    }
    static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);

        return gcd(a, b-a);
    }

    // function to check and print if
    // two numbers are co-prime or not
    static boolean isCoPrime(int a, int b) {

        if ( gcd(a, b) == 1)
            return true;
        else
            return false;
    }

    static void getSubArray(int arr[], int data[], int start,
                            int end, int index, int r, List listOfSubArrays)
    {

        // Current subarray is ready to be returned
        if (index == r)
        {
            int[] subArray = new int[r];
            int count = 0;
            for (int j=0; j<r; j++) {
                subArray[count] = data[j];
                System.out.print(subArray[count]);
                count++;

            }
            //System.out.println(subArray);
            System.out.println("");
            listOfSubArrays.add(subArray);
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            getSubArray(arr, data, i+1, end, index+1, r, listOfSubArrays);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses getSubArray()
    static void printCombination1(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        List<int[]> listOfSubArrays = new ArrayList<>();
        // Print all combination using temprary array 'data[]'
        getSubArray(arr, data, 0, n-1, 0, r, listOfSubArrays);
        System.out.println("Arrays are : \n");
        */
/*for(int i=0;i<listOfSubArrays.size();i++){
            System.out.println(listOfSubArrays.get(i));
        }*//*

    }


  */
/* static List getSubArrays(int minValue, int maxValue, int k){
       int arr[] = new int[k];


    }

public int calculateTotalRotorConfiguration(int rotorCount, int minRotorValue, int maxRotorValue){
    //create subarrays of length rotorCount from minRotorValue to maxRotorValue
    List listofNumber = getSubArrays(minRotorValue, maxRotorValue, rotorCount); // of length rountCount
    int counter = 0; // from all possibilities , if coprime condition is also true, increase teh counter

    for(int i=0;i<listofNumber.size();i++) {

        int[] arr = (int[]) listofNumber.get(i);
        for (int index = 1; index <arr.length;index++){
            if(isCoPrime(arr[0],arr[index]))
                counter++;
        }
    }
    return counter;

}*//*

  static void combinationUtil(int arr[], int data[], int start,
                              int end, int index, int r)
  {
      // Current combination is ready to be printed, print it
      if (index == r)
      {
          for (int j=0; j<r; j++){
              System.out.print(data[j]+" ");
          }
          System.out.println("");
          return;
      }

      // replace index with all possible elements. The condition
      // "end-i+1 >= r-index" makes sure that including one element
      // at index will make a combination with remaining elements
      // at remaining positions
      for (int i=start; i<=end && end-i+1 >= r-index; i++)
      {
          data[index] = arr[i];
          combinationUtil(arr, data, i+1, end, index+1, r);
      }
  }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r, listofNumbers);
    }
    public static void main(String args[]){
        //System.out.println(AcunaQuestion.numSubarrayProductLessThanK(new int[]{3, 4, 5, 12, 20, 60}, 5));

        int[] arr = {1, 2, 3, 4, 5};
        printCombination(arr,arr.length,3);
    }

}
*/
