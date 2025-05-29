package dp;

//Longest Increasing Subsequence
public class LIS {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] dp = new int[arr.length];
        dp[0] = 1;
        System.out.println(lengthOfLIS(arr,dp)); // Output: 4
    }

    public static int lengthOfLIS(int[] nums, int[] dp) {

        for(int i=1;i<nums.length;i++){

            if(nums[i]>=nums[i-1]){
                //include
                dp[i] = dp[i-1]+1;
            }else{
                //not include
                dp[i] = dp[i-1];
            }
        }

        return dp[nums.length-1];



    }
}
