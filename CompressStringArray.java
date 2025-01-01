/**
 *
 * Question: https://leetcode.com/problems/string-compression/description/
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 *
 *
 * Approach
 * Initialization: Start with a pointer i that will traverse the list of characters. Use another pointer idx to track where the next character or count should be placed in the list.
 * Traverse the characters: Iterate through the list using the i pointer. For each character:
 * Count the number of consecutive occurrences of the current character.
 * Store the character at position idx and, if the count is greater than 1, convert the count to a string and store each digit in the list after the character.
 * Resize the list: After the loop, the list may contain extra characters. Resize it to idx to return only the relevant part.
 * Return the new length: The function should return the length of the modified list.
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * */

public class CompressStringArray {
    public static int compress(char[] chars) {
        int idx = 0; //index to track where the next character or count should be placed
        int compressCount = 1;
        for(int i=0;i<chars.length;i++) {

            //either last character or different sequence starts then update the array
            if((i+1)==chars.length || chars[i]!=chars[i+1]) {
                chars[idx++] = chars[i];
                if(compressCount > 1) { //chk logic for digit>1
                    for (char digit : Integer.toString(compressCount).toCharArray()) {
                        chars[idx++] = digit;
                    }
                }
                compressCount = 1;
            }
            else if(chars[i] == chars[i+1]) {
                compressCount++;
            }
        }
        return idx;
    }
    public static void main(String []args) {
        /*
        Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".


         */

        char[] chars = {'a', 'a','b','b','c','c','c'};
        System.out.println(compress(chars));

    }
}
