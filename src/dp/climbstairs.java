package dp;

import java.util.Arrays;

public class climbstairs {


    public static void main(String[] args) {
        int n=5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        dp[1] = 1;
        System.out.println("Number of ways to climb stairs: " + climbStairs(n, dp));
    }

    public static int climbStairs(int n, int[] dp){

        if(dp[n] != Integer.MAX_VALUE){
            return dp[n];

        }

       dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);

        return dp[n];
    }
}
