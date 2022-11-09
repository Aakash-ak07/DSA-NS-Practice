package Array;

import java.util.Arrays;
import java.util.*;

//Length of the longest substring without repeating characters
//For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("Input String : " + str);
        // System.out.println(uniqueSubString(str));
        // System.out.println(uniqueSubString2(str));
        System.out.println(uniqueSubString3(str));
        // System.out.println(longestSubstring4(str));

        sc.close();
    }
    // T C -> O(N) S C-> O(D)
    // UsingStartIdx and EndingIdx

    /* static final int NoOfChars = 256; //int[256] for Extended ASCII */
    public static int uniqueSubString(String str) {
        int n = str.length();

        int res = 0;
        int[] lastIndex = new int[256]; // NoOfChars
        Arrays.fill(lastIndex, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);
            res = Math.max(res, j - i + 1);
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }

    /*
     * // Using HashMap using extra space
     * public static int uniqueSubString2(String s) {
     * HashMap<Character, Integer> map = new HashMap<>();
     * int maxLen = 0;
     * int start = 0;
     * 
     * for (int end = 0; end < s.length(); end++) {
     * if (map.containsKey(s.charAt(end))) {
     * // If we have map the number, move the start pointer // to position after
     * the last occurrence
     * start = Math.max(start, map.get(s.charAt(end)) + 1);
     * }
     * // Updating the last map value of the character
     * map.put(s.charAt(end), end);
     * maxLen = Math.max(maxLen, end - start + 1);
     * }
     * return maxLen;
     * }
     */

    // Using Sliding Window --> O(n)
    public static int uniqueSubString3(String str) {
        String temp = "";
        int maxLen = 0;
        if (str.isEmpty())
            return 0;

        else if (str.length() == 1)
            return 1;

        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);
            // If string already contains the character// Then substring after repeating
            // character
            if (temp.contains(current)) {
                temp = temp.substring(temp.indexOf(current) + 1);
            }
            temp = temp + String.valueOf(c);
            maxLen = Math.max(temp.length(), maxLen);
        }
        return maxLen;
    }

    // sliding window Optimised method
    // public static int longestSubstring4(String s) {
    // int n = s.length(), ans = 0;
    // Map<Character, Integer> map = new HashMap<>(); // current index of character
    // // try to extend the range [i, j]
    // i = 0;
    // for (int j = 0; j < n; j++) {
    // if (map.containsKey(s.charAt(j))) {
    // i = Math.max(map.get(s.charAt(j)), i);
    // }
    // ans = Math.max(ans, j - i + 1);
    // map.put(s.charAt(j), j + 1);
    // }
    // return ans;
    // }
}

// Input : NewTonSchool
// Output : 9
