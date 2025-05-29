package dp;

public class DecodeWays {

    public static void main(String[] args) {

        System.out.println(numberOfDecodeways("226"));

    }

    private static int numberOfDecodeways(String s){

        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()+1];

        dp[0] = dp[1] = 1;

        for(int i=2;i<=s.length();i++){

            int one = Character.getNumericValue(s.charAt(i-1));
            int two = Integer.parseInt(s.substring(i-2,i));

            if(one>=1 && one <=9){
                dp[i] += dp[i-1];
            }
            if(two>=10 && two <=26){
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];

    }
}
