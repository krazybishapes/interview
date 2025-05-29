package Rippling;

import java.util.*;

public class Song {

    static Map<Integer, Set<Integer>> songUserMap = new HashMap<>();
    static Map<Integer, Deque<Integer>> userSongMap = new HashMap<>();

    static int SONG_LIMIT_PER_USER = 3;

    public static void main(String[] args) {
        //Given a list of songs, and users playing songs, return the list of songs in descending order of most unique users playing the songs
        int[][] input = {{0,0},{1,2},{1,0},{2,1},{2,3},{2,0}};
        for(int i=0;i<input.length;i++){
            int songId = input[i][0];
            int userId = input[i][1];
            recordPlay(songId,userId);
        }
        findMostPlayedSongByUniqueUsers(input);
        findMostPlayerSongByUsers();

    }



    private static void findMostPlayerSongByUsers() {

        for(Map.Entry<Integer,Deque<Integer>> entry: userSongMap.entrySet()){
            System.out.println("Recent"+SONG_LIMIT_PER_USER +" song player by user:"+entry.getKey()+" "+ entry.getValue());
        }
    }

    private static void recordPlay(int songId, int userId) {

        songUserMap.computeIfAbsent(songId, k->new HashSet<>()).add(userId);

        Deque<Integer> songs = userSongMap.computeIfAbsent(userId, k->new LinkedList<>());

        //remove duplicate song
        songs.remove(songId);
        songs.addLast(songId);

        if(songs.size()>SONG_LIMIT_PER_USER){
            songs.removeFirst();
        }


    }

    private static void findMostPlayedSongByUniqueUsers(int[][] input) {
        //System.out.println(songUserMap.size());
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        songUserMap.forEach((k,v)->{
            queue.add(new int[]{k,v.size()});
        });
        //System.out.println(queue.size());

        while(!queue.isEmpty()){
            System.out.println(queue.poll()[0]);
        }
    }
}
