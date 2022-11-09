package DP;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0) // this will make (0,0) as false and then next
                { // line will make it true again so not adding cond. (j!=0)
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j] == true)
                        dp[i][j] = true;
                    else {
                        int val = arr[i - 1];
                        if (j >= val) {
                            if (dp[i - 1][j - val] == true)
                                dp[i][j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][target]);
        sc.close();
    }
}

// Target sum Subsets
// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. You are required to calculate and print true or false, if there is a
// subset the elements of which add up to "tar" or not.

// Input :
// n = 5
// targrt = 10
// arr = 4 2 3 1 7

// Output: true