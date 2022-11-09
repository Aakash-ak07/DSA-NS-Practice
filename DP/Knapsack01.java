package DP;

import java.util.Scanner;

public class Knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();
        int value[] = new int[n];
        for (int i = 0; i < value.length; i++) {
            value[i] = sc.nextInt();
        }
        int weight[] = new int[n];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = sc.nextInt();
        }

        int dp[][] = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= weight[i - 1]) {
                    int remCap = j - weight[i - 1];

                    if (dp[i - 1][remCap] + value[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][remCap] + value[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j]; // when i does no pickup--value
                    }
                } else {
                    dp[i][j] = dp[i - 1][j]; // whien i doen not pickup--value
                }
            }
        }
        System.out.println(dp[n][cap]);
        sc.close();
    }
}

// Input
// 5
// 7
// 15 14 10 45 30
// 2 5 1 3 4

// Output:
// 75