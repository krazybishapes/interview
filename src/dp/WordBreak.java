package dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {

        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(helper("leetcode",wordDict));
    }

    private static boolean helper(String s, List<String> wordDict){

        int n = s.length();

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=0;i<n;i++){

            for(String word: wordDict){

                int start = i-word.length();

                if(start>=0 && (dp[start] && s.substring(start,i).equals(word))){

                        dp[i] = true;

                }


            }
        }

        return dp[s.length()];

    }
}
