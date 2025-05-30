package dp;

public class UniquePath {

    public static void main(String[] args) {

        int m=3;
        int n=7;
        int[][] dp = new int[m][n];
        System.out.println(findUniquePath(m,n, dp));

    }

    public static int findUniquePath(int m, int n, int[][] dp){


       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){

               if(i==0 || j==0){
                   dp[i][j] = 1;
               }else{
                   dp[i][j] = dp[i-1][j]+dp[i][j-1];
               }


           }
       }

       return dp[m-1][n-1];

    }
}
