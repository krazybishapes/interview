package dp;

public class JumpGame2 {

    public static void main(String[] args) {
        System.out.println(countJump(new int[]{2,3,1,1,4}));
        System.out.println(countJump(new int[]{2,3,0,1,4}));
        System.out.println(countJump(new int[]{2,0,0,1,4}));
    }

    private static int countJump(int[] nums){

        int farthest = 0, end =0, jump=0;

        for(int i=0;i<nums.length;i++){

            farthest = Math.max(farthest, i+nums[i]);

            if(farthest>= nums.length-2){
                return ++jump;
            }

            if(i==end){
                if(nums[i] == 0){
                    return 0;
                }
                ++jump;
                end = farthest;
            }
        }
        return 0;
    }
}
