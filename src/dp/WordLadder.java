package dp;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

        String begin = "hit";
        String end = "cog";

        String[] words = {"hot","dot","dog","lot","log","cog"};


        System.out.println(findWordLadderCount(begin, end, List.of(words)));
    }

    private static int findWordLadderCount(String begin, String end, List<String> words) {

        Set<String> visited = new HashSet<>();
        visited.add(begin);
        Set<String> wordSet = new HashSet<>(words);

        if(!wordSet.contains(end)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        int result = 1;

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i=0;i<size;i++){

                String word = queue.poll();


                for(String neighbour: getNeighbours(word, wordSet)){
                    if(neighbour.equals(end)){
                        return result +1;
                    }
                    if(!visited.contains(neighbour)){
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }



                }


            }
            result++;
        }
        return 0;
    }

    private static List<String> getNeighbours(String word, Set<String> wordSet) {

        List<String> neighbours = new ArrayList<>();

        char[] chars = word.toCharArray();

        for(int i=0;i<chars.length;i++){
            char original = chars[i];
            for(char c='a'; c<='z';c++){
                if(c==original) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if(wordSet.contains(newWord)){
                    neighbours.add(newWord);
                }
            }
            chars[i] = original;
        }

       // System.out.println(neighbours.size());

        return neighbours;



    }


}
