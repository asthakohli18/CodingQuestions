/**
 * Created by kohas02 on 9/15/18.
 */
public class SearchNumberInSortedRotatedArr {


    private int searchNumberInSortedRotatedArray(int[] arr, int left, int right, int numberToBeSearched){

        if(left > right)
            return -1;

        int mid = (left+right)/2;
        if(arr[mid]==numberToBeSearched){
            return mid;
        }

        if(arr[left] <= arr[mid]) //left array is sorted
        {
            if(numberToBeSearched >= arr[left] && numberToBeSearched <= arr[mid]) //element is present in this section
            {
                return searchNumberInSortedRotatedArray(arr, left, mid-1, numberToBeSearched);
            }
            return searchNumberInSortedRotatedArray(arr, mid+1, right, numberToBeSearched);
        }

        if(arr[mid]<= arr[right]) //right array is sorted
        {
            if(numberToBeSearched >= arr[mid] && numberToBeSearched <= arr[right]) {
                return searchNumberInSortedRotatedArray(arr, mid+1, right, numberToBeSearched);
            }
            return searchNumberInSortedRotatedArray(arr, left, mid-1, numberToBeSearched);
        }

        return -1;

    }

    public static void main(String args[]){
        SearchNumberInSortedRotatedArr obj = new SearchNumberInSortedRotatedArr();
        int[] arr={3,4,5,1,2};
        System.out.println("\n "+obj.searchNumberInSortedRotatedArray(arr, 0, 5, 1));
    }


}
