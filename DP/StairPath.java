package DP;

import java.util.Scanner;

public class StairPath {
    public static int countPath(int n, int[] ans) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;
        // if (ans[n] > 0)
        //     return ans[n];

        int cp1 = countPath(n - 1, ans);
        int cp2 = countPath(n - 2, ans);
        int cp3 = countPath(n - 3, ans);
        int cp = cp1 + cp2 + cp3;

        // ans[n] = cp;
        return cp;
    }

    public static void main(String[] args) {
        // int n = 4;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cp = countPath(n, new int[n + 1]);
        System.out.println(cp);

        sc.close();   //only remove scanner error in vs-code so i have used this..
    }
}
