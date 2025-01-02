/**
 *  subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * */

public class StringIsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int indexs=0; int indext =0;
        while(indexs<s.length() && indext<t.length()) {
            if(s.charAt(indexs) == t.charAt(indext)) {
                indexs++;
            }
            indext++;
        }
        return indexs == s.length();
    }
    public static void main(String[] args) {
/*
Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 */
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}
