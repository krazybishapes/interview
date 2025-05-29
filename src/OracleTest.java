public class OracleTest {

    public static void main(String[] args) {

        int[] arr ={2, 7, 6, 1, 4, 5};
        int k = 3;

        findSumDivisibleByK(arr,k);
    }

    private static int findSumDivisibleByK(int[] arr, int k ){
        int left =0;
        int right =0;
        int sum=0, result=0, count=0;

        while(left<right && right< arr.length){

            sum += arr[right];

            if(sum %k ==0){
                count++;
                result = Math.max(result,count);
            }

            right++;
            if(right == arr.length-1){
                left++;
                right = left;
            }

        }
        return -1;
    }

}
