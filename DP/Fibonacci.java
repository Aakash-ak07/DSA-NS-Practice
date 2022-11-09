package DP;

import java.util.*;

public class Fibonacci {
    public static int fibSeries(int n) {
        if (n == 0 || n == 1)
            return n;

        return (fibSeries(n - 1) + fibSeries(n - 2));
    }

    // using DP--> Memoization
    public static int fibSeriesDP(int n, int[] ans) {
        if (n == 0 || n == 1)
            return n;

        if (ans[n] != 0)
            return ans[n];

        // int f1 = fibSeriesDP(n - 1, ans);
        // int f2 = fibSeriesDP(n - 2, ans);
        // int fibNum = f1 + f2;

        int fibNum = fibSeriesDP(n - 1, ans) + fibSeriesDP(n - 2, ans);
        ans[n] = fibNum;

        return fibNum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // int n = 43;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibSeriesDP(n, new int[n + 1]));
        // System.out.println(fibSeries(n));

        sc.close();  // only remove errot in vs code so i used this
    }
}
