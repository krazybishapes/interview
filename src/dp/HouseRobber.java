package dp;

public class HouseRobber {

    public static void main(String[] args) {

        int[] arr = {1,2,3,1};
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        int result = robHouse(arr, dp);
        System.out.println("Maximum amount of money that can be robbed: " + result);
    }

    public static int robHouse(int[] arr, int[] dp) {

        int n = arr.length;
        for(int i=2;i<n; i++){
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}
