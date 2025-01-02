/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 */
public class MaxNumberOfVowelInSubstringOfgivenLength {
    public static int maxVowels(String s, int k) {
        int start = 0; int end = 0;
        int maxCount = 0; int currentWindowCount = 0;
        while(end < s.length()) {
            if(end < k) {
                if(isVowel(s.charAt(end))) {
                    currentWindowCount++;
                }
                end++;
                maxCount = currentWindowCount;
            } else {
                if(isVowel(s.charAt(start))) {
                    currentWindowCount--;
                }
                start++;
                if(isVowel(s.charAt(end))) {
                    currentWindowCount++;
                }
                end++;
                maxCount = Math.max(maxCount, currentWindowCount);
            }
        }
        return maxCount;
    }
    public static boolean isVowel(char a){
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u' )return true;
        if(a=='A' || a=='E' || a=='I' || a=='O' || a=='U' )return true;
        return false;
    }
    public static void main(String[] args) {
        /*
        Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
         */
        System.out.println(maxVowels("leetcode", 3));
    }
}
