public class MergeStringAlternatively {
    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int p=0;int q=0;
        StringBuilder sb = new StringBuilder();
        while(p<len1 && q<len2) {
            sb.append(word1.charAt(p)).append(word2.charAt(q));
            p++;
            q++;
        }
        if(p<len1) {
            sb.append(word1.substring(p,len1));
        } else if(q<len2) {
            sb.append(word2.substring(q,len2));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        /*
            Input: word1 = "abc", word2 = "pqr"
            Output: "apbqcr"
         */
        /*
            Input: word1 = "ab", word2 = "pqrs"
            Output: "apbqrs"
         */
        /*
            Input: word1 = "abcd", word2 = "pq"
            Output: "apbqcd"
         */
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1,word2));
    }
    }
