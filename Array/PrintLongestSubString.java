package Array;

import java.util.HashMap;

public class PrintLongestSubString {
    public static String findLongeString(String str) {
        int st = 0;
        int i;
        int n = str.length();
        int currentLength = 0;
        int maxLen = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(0), 0);
        for (i = 1; i < n; i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), i);
            } else {
                if (map.get(str.charAt(i)) >= st) {
                    currentLength = i - st;
                    if (maxLen < currentLength) {
                        maxLen = currentLength;
                        start = st;
                    }
                    st = map.get(str.charAt(i)) + i;
                }
                map.replace(str.charAt(i), i);
            }
        }
        if (maxLen < i - st) {
            maxLen = i - st;
            start = st;
        }
        return str.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String str = "NewtonSchool";
        System.out.print(findLongeString(str));
    }
}

// Input : NewtonSchool
// Output : NewtonSch

// Input : ABDEFGABEF
// Output : BDEFGA