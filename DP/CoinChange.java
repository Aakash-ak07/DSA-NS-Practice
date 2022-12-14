package DP;

import java.util.Scanner;

//coinChange Combination
public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        int dp[] = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] += dp[j - arr[i]]; // way of method to payment of j so...
            }
        }
        System.out.println(dp[amount]);

        sc.close(); // only remove scanner error in vs-code so i have used this..
    }
}
