/**
 * Created by kohas02 on 6/30/18.
 */


public class StringUtil {

/**
 * erbottlewat is rotation of waterbottle
 *
 *  s1 = xy = waterbottle
    x = wat
    y = erbottle
    s2 = yx = erbottlewat
 *
 * */
    private boolean isRotate(String s1, String s2){

        if(s1.length() != s2.length())
            return false;

        else
        {
            String concattedStr = s1+s1;
            return concattedStr.contains(s2);
        }
    }


    private boolean isPalindrome(String str){

        StringBuilder reverseStr = new StringBuilder(str);
        reverseStr = reverseStr.reverse();

        return (str.toString().equals(reverseStr.toString()));
    }

    /**
     *
     * Example : the string aabcccccaaa would become a2blc5a3
     *If the
     "compressed" string would not become smaller than return the original string,
     * */
    private String compressStrings(String s){
        StringBuilder str = new StringBuilder("");
        int consequetiveCount = 0;
        for(int i =0;i< s.length();i++){

            consequetiveCount++;

            if((i+1)>=s.length() || s.charAt(i)!= s.charAt(i+1) ){
                str.append(s.charAt(i));
                str.append(consequetiveCount);
                consequetiveCount = 0;
            }

        }

        return (str.length() < s.length()) ? str.toString() : s;
    }


    /**
     *
     * Remove a character from a string to make it a palindrome
     * what index is that?
     * */
    private int removeCHaracterToMakePalindrome(String str){

        StringBuilder reverseStr = new StringBuilder(str);
        reverseStr = reverseStr.reverse();

        int high = str.length()-1;
        int low=0;

        if(isPalindrome(str) && isPalindrome(reverseStr.toString())){
            // if string is palindrome, return the middle element -> string will still remain a palindrome
            return str.length()/2;
        }

        while(low<high){

            if(str.charAt(low) == str.charAt(high)){
                low++;
                high--;
            }
            else{
                if(isPalindrome(str.substring(low+1,high+1))){
                    return low;
                }
                if(isPalindrome(str.substring(low, high))){
                    return high;}

                return -1;
            }

        }


            return -2;
    }

    public static void main(String args[]){
        StringUtil obj = new StringUtil();
        System.out.println("aabcccccaaa EXPECTED a2blc5a3 but ACTUAL "+obj.compressStrings("aabcccccaaa"));


        System.out.println("erbottlewat is rotation of waterbottle EXPECTED true ACTUAL "+obj.isRotate("waterbottle", "erbottlewat"));

        System.out.println("is Palindrome ? Astha : EXPECTED False ACTUAL "+obj.isPalindrome("Astha"));
        System.out.println("is Palindrome ? ANJNA : EXPECTED True ACTUAL "+obj.isPalindrome("ANJNA"));


        System.out.println("which index to remove To Make Palindrome ? abcba "+obj.removeCHaracterToMakePalindrome("abcba"));
        System.out.println("which index to remove To Make Palindrome ? abecbea "+obj.removeCHaracterToMakePalindrome("abecbea"));
        System.out.println("which index to remove To Make Palindrome ? abcbea "+obj.removeCHaracterToMakePalindrome("abcbea"));
    }


}
