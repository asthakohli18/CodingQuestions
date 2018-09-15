import java.util.HashSet;

/**
 * Created by kohas02 on 8/9/18.
 */
public class HashSetUtils {

    private int lengthOfLongestConseqSubSeq(int[] arr){
        int res=0;

        HashSet<Integer> set = new HashSet();
        for(int num:arr) {
            set.add(num);
        }

        for(int i=0;i<arr.length;i++ ){
            int num = arr[i];
            int j=1;
            while(set.contains(num+1)){
                j++;
                num++;
            }
            res = Math.max(res,j);

        }
        return res;
    }
    public static void main(String args[]){
        HashSetUtils hashSetUtils = new HashSetUtils();
        int res = hashSetUtils.lengthOfLongestConseqSubSeq(new int[]{1,9,3,10,4,20,2});
        System.out.println("\nLength of longest Consecutive subsequence {1,9,3,10,4,20,2} = "+res); //1,3,4,2


        res = hashSetUtils.lengthOfLongestConseqSubSeq(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42});
        System.out.println("\nLength of longest Consecutive subsequence {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42} = "+res);
    }
}
