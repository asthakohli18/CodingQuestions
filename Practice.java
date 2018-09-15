import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kohas02 on 6/27/18.
 */
public class Practice {

    //You can also use , Collections.reverse(ArrayList)
    private Integer[] reverseAnArray(Integer[] arr)
    {
        int len = arr.length;
        for(int i=0;i<len/2;i++){
            int tmp = arr[i];
            arr[i]=arr[len-i-1];
            arr[len-i-1]=tmp;
        }
        return arr;
    }


    private boolean isPrime(int n){
        for(int x=2; x<= Math.sqrt(n); x++)
        {
            if(n%x==0)
                return false;
        }
        return true;
    }

    private int factorial(int n){
        if(n<0 )
            return -1;
        if(n==0 )
            return 1;
        else
            return n*factorial(n-1);
    }

    private void permutation(String str){
        permutation(str, "");
    }

    private void permutation(String str, String prefix) {
        if(str.length()==0){
            System.out.println(prefix);
        } else{
            for(int i=0;i<str.length();i++){
                String rem = str.substring(0,i)+str.substring(i+1);
                permutation(rem, prefix+str.charAt(i));
            }
        }

    }

    private int nthFibonacci(int n){
        if(n <= 0)
            return 0;
        else if(n==1)
            return 1;

        return nthFibonacci(n-1) + nthFibonacci(n-2);
    }

    //all fibonacci elements till nth without recursion
    private void allFibonacci(int n){
        int x1=0;
        int x2 =1;
        int x = x1+x2;
        System.out.print(x1);
        System.out.print(" "+x2);
        for(int i=2 ; i<n; i++)
        {
            System.out.print(" "+x);
            x1 = x2;
            x2 = x;
            x = x1+x2;
        }
    }
    //all fibonacci elements till nth with recursion
    private void allFibonacciWithRecursion(int n){
        for(int i=0;i<n;i++){
            System.out.print(" "+nthFibonacci(i));
        }
    }

    private int powersOf2Tilln(int n){
        if(n<1)
            return 0;
        else if(n==1){
            System.out.print(1);
            return 1;
        }
        else{
            int prev = powersOf2Tilln(n/2);
            int curr = 2* prev;
            System.out.print(" " +curr);
            return curr;
        }

    }

    //to check if input string has all unique characters
    private boolean isUniqueChars(String str){
        //assumption : charset is 128 chars
        boolean[] charset = new boolean[128];
        if(str.length()>128)
            return false;

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(charset[c]){
                return false;
            }
            charset[c]=true;
        }

        return true;
    }

    private String sort(String str){
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        return new String(strArray);
        //return strArray.toString();
        //return String.valueOf(strArray);
    }

    private static String sortUsingComparator(String str){
        List<Character> list = str.chars().mapToObj(c-> (char)c).collect(Collectors.toList());
        Collections.sort(list,
            (c1,c2)-> {return c1.compareTo(c2);}
        );
        return String.valueOf(list);
    }

    private boolean isPermutation(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        return sort(str1).equals(sort(str2));
    }

    private boolean isPermutationByCountingChars(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        int[] countAtCharIndex = new int[128];
        char[] s_str1 = str1.toCharArray();
        for(char c1:s_str1)
        {
            countAtCharIndex[c1]++;
        }
        char[] s_str2 = str2.toCharArray();
        for(char c2:s_str2){
            countAtCharIndex[c2]--;
            if(countAtCharIndex[c2]<0)
                return false;
        }
        return true;
    }

    private boolean isPermutationOfPalindrome(String str){
        int[] table = buildFreqTable(str);
        return checkOddValue(table);
    }

    private int[] buildFreqTable(String str){
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            int x = getCharNumber(c);
            if(x!=-1) {
                table[x]++;
            }
        }
        return table;
    }
    private int getCharNumber(char c){
        int a_num=Character.getNumericValue('a');
        int z_num=Character.getNumericValue('z');
        int val=Character.getNumericValue(c);
        if(val>=a_num && val<=z_num )
            return val-a_num;
        return -1;
    }

    private boolean checkOddValue(int[] table){
        boolean foundOdd = false;
        for(int val: table){
            if(val%2==1){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }

        }
        return foundOdd;
    }

    public static void main(String[] main){
        Practice practice = new Practice();

        Integer[] evenLenArrayToBeReversed = {1,2,3,4,5,6};
        Integer[] evenLenReversedArray = practice.reverseAnArray(evenLenArrayToBeReversed);
        ArrayList<Integer> evenLenReversedList = new ArrayList<>(Arrays.asList(evenLenReversedArray));
        System.out.println("evenLenReversedList \n"+evenLenReversedList);


        Integer[] oddLenArrayToBeReversed = {1,2,3,4,5};
        Integer[] oddLenReversedArray = practice.reverseAnArray(oddLenArrayToBeReversed);
        ArrayList<Integer> oddLenReversedList = new ArrayList<>(Arrays.asList(oddLenReversedArray));
        System.out.println("oddLenReversedList \n"+oddLenReversedList);

        System.out.println("7 is prime ? "+practice.isPrime(7));
        System.out.println("4 is prime ? "+practice.isPrime(4));

        System.out.println("Factorial of 5 is "+practice.factorial(5));

        /*
        System.out.println("permutation of string abcde are ");
        practice.permutation("abcde");*/

        System.out.println("6th element in fibonacci = "+ practice.nthFibonacci(6) );

        System.out.println("\nall fibonacci till 10th element Without recursion");
        practice.allFibonacci(10);

        System.out.println("\nall fibonacci till 10th element With recursion");
        practice.allFibonacciWithRecursion(10);

        System.out.println("\npowersOf2Tilln for n = 8 ");
        practice.powersOf2Tilln(8);

        System.out.println("\nAre the characters in the given string all Unique ? Str = astha");
        System.out.println(practice.isUniqueChars("astha"));
        System.out.println("\nAre the characters in the given string all Unique ? Str = GOD");
        System.out.println(practice.isUniqueChars("GOD"));

        System.out.println("\nis str1 Permutation of str2? str1=astha, str2=rajan");
        System.out.println(practice.isPermutation("astha","rajan"));

        System.out.println("\nis str1 Permutation of str2? str1=astha, str2=aasth");
        System.out.println(practice.isPermutation("astha","aasth"));

        System.out.println("\nis str1 Permutation of str2? str1=astha, str2=rajan");
        System.out.println(practice.isPermutationByCountingChars("astha","rajan"));

        System.out.println("\nis str1 Permutation of str2? str1=astha, str2=aasth");
        System.out.println(practice.isPermutationByCountingChars("astha","aasth"));

        System.out.println("\nis permutation of a palindrome ? str = ANJNA");
        System.out.println(practice.isPermutationOfPalindrome("ANJNA"));
        System.out.println("\nis permutation of a palindrome ? str = ANNAJ");
        System.out.println(practice.isPermutationOfPalindrome("ANNAJ"));
        System.out.println("\nis permutation of a palindrome ? str = RAJAN");
        System.out.println(practice.isPermutationOfPalindrome("RAJAN"));

        /**
         * This is to reverse a list of strings
         * */
        List array = new ArrayList<String>();
        array.add("a");
        array.add("j");
        array.add("k");
        array.add("d");
        array.add("t");

        System.out.println("b4 sorting list "+array);
        Collections.sort(array,Collections.reverseOrder());
        System.out.println("after sorting list "+array);


        System.out.println("\nSorting a string using comparator with lambda and streams concept\n");
        System.out.println(sortUsingComparator("astha"));
    }
}
