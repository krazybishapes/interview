package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {


        String s = "abc";

        List<String> result = new ArrayList<>();
        findCombination(s,0,"", result);

        for(String r: result){
            System.out.println(r);
        }
    }

    private static void findCombination(String s, int index, String current, List<String> combinations){
        //base condition
        if(index == s.length()){
            combinations.add(current);
            return;
        }


        //skip the char at index
        findCombination(s, index+1,current,combinations);

        //include the chat at index
        findCombination(s,index+1, current+s.charAt(index), combinations);

    }
}
