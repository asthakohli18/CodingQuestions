public class GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) {
            return "";
        }
        int l = gcd(str1.length(), str2.length());
        return str1.substring(0, l);
    }
    private static int gcd(int div, int by) {
        while(by!=0) {
            int rem = div % by;
            div = by;
            by = rem;
        }
        return div;
    }
    public static void main(String[] args) {
        /*
            Input: str1 = "ABCABC", str2 = "ABC"
            Output: "ABC"
        */
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
        /*
            Input: str1 = "ABABAB", str2 = "ABAB"
            Output: "AB"
        */
        /*
        *
        * Input: str1 = "LEET", str2 = "CODE"
          Output: ""
        * */
    }
}
