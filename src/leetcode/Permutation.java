package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        String s = "abc";

        List<String> result = new ArrayList<>();

        findPermutation("",s, result);

        for(String r: result){
            System.out.println(r);
        }
    }

    private static void findPermutation(String processed, String unprocessed, List<String> result){
        if(unprocessed.isEmpty()){
            result.add(processed);
        }

        for(int i=0;i<unprocessed.length();i++){

            findPermutation(processed+ unprocessed.charAt(i),
                    unprocessed.substring(0,i)+unprocessed.substring(i+1),
                    result);

        }
    }
}
