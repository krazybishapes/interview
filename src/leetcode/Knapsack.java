package leetcode;

public class Knapsack {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        // Build the DP array
        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                System.out.println(w - weights[i] + " " + dp[w]);
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
                System.out.println(" now:" + dp[w]);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        System.out.println("Maximum value: " + knapsack(weights, values, capacity));
    }
}
