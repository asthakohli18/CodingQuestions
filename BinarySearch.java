/**
 * Created by kohas02 on 7/5/18.
 */
public class BinarySearch {

    private int binarySearch(int[] arr, int l, int r, int elem){
        if(l<=r){
            int mid = l+(r-1)/2;

            if(elem == arr[mid])
                return mid;

            else if(elem< arr[mid]){
                // serach in left subarray
                return binarySearch(arr,l,mid-1, elem);
            }
            else{
                // serach in right subarray
                return binarySearch(arr,mid+1,r, elem);
            }
        }
        return -1;
    }

}
