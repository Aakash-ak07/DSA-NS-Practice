package DP;

import java.util.Scanner;

//variable no of jumps..  // using Tabulation method
public class ClimbStairwithJumps {
    public static void main(String[] args) {
        // int arr[] = {5,5,2,4,1,5,9,8,6,3,8,9,1};
        // int n = arr.length;
        // int dp[] = new int[arr.length+1];
        // dp[n] = 1;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) // way of dp[i] to n
        {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) // j < dp.length because if we reach end of loop they
                                                                   // will not jump stair after reach of 0 stair or
                                                                   // reach position and resolve out of bound exception
            {
                dp[i] += dp[i + j];
            }
        }
        System.out.println(dp[0]);
        sc.close();
    }
}

// Input 13
// 5,5,2,4,1,5,9,8,6,3,8,9,1

// output 2044
