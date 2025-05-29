package dp;

public class MaxSubarray {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(arr);
        System.out.println("Maximum subarray sum: " + result);
    }

    public static int maxSubArray(int[] arr){

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum < 0){
                sum = 0;
            }else{
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
