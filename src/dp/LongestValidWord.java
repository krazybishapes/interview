package dp;

import java.util.*;

public class LongestValidWord {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("string", "sring", "sing", "wording", "ing", "ng", "g");
        System.out.println(findLongestValidWord(words));  // Output: string
    }

    private static int findLongestValidWord(List<String> words) {

        Set<String> wordSet = new HashSet<>(words);
        int maxLength = 0;

        for(String word: words){
            if(isValid(word, wordSet)){
               maxLength = Math.max(maxLength,word.length()) ;
            }
        }

        return maxLength;
    }

    private static boolean isValid(String word, Set<String> wordSet){


        if(word.length()==1 && wordSet.contains(word)){
            return true;
        }

        if(!wordSet.contains(word)){
            return false;
        }

        for(int i=0;i<word.length();i++){

            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            String subWord = sb.toString();
            if(wordSet.contains(subWord) && isValid(subWord,wordSet)){
                return true;
            }
        }

        return false;
    }


}

