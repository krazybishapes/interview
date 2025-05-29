package Rippling;

import java.util.*;

public class MusicPlayer {

    static class Song{
        private String songTitle;
        private int id;

        public Song(int id,String songTitle){
            this.songTitle = songTitle;
            this.id = id;
        }
    }

    private Map<Integer,Song> songs;
    private static int index = 1;

    private final Map<Integer, Deque<Integer>> userSongPlayList;
    private final Map<Integer,Set<Integer>> songUserMapping;
    private final PriorityQueue<int[]> mostPlayedSongs;
    private static int userSongPlayListCapacity = 5;

    public MusicPlayer(){
        this.songs = new HashMap<>();
        this.userSongPlayList = new HashMap<>();
        songUserMapping = new HashMap<>();
        mostPlayedSongs = new PriorityQueue<>((a,b)->b[1]-a[1]);
    }

    public int addSong(String songTitle){
        Song song = new Song(index++, songTitle);
        this.songs.put(song.id, song);
        return song.id;
    }

    public void playSong(int songId, int userId){

        songUserMapping.computeIfAbsent(songId, k->new HashSet<>()).add(userId);

        Deque<Integer> songList = userSongPlayList.computeIfAbsent(userId,k->new LinkedList<>());

        songList.remove(songId);
        songList.addLast(songId);

        if(songList.size()>userSongPlayListCapacity){
            songList.removeFirst();
        }
    }

    public void printMostPlayedSongs(){

        for(Map.Entry<Integer, Set<Integer>> entry: songUserMapping.entrySet()){
            mostPlayedSongs.add(new int[]{entry.getKey(), entry.getValue().size()});
        }

        while(!mostPlayedSongs.isEmpty()){
            int[] song = mostPlayedSongs.poll();
            System.out.println(songs.get(song[0]).songTitle +" is played by " + song[1]+" users");
        }

    }

    public List<Integer> getLastThreeSongs(int userId){
        Deque<Integer> userSongs = userSongPlayList.get(userId);
        List<Integer> list = new ArrayList<>();
        for(int song: userSongs){
            list.add(userSongs.getLast());
        }

        return list;
    }

    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.addSong("Sajna");
        musicPlayer.addSong("Hiriye");
        musicPlayer.addSong("Channa Be");

        for(int i=1;i<=3;i++){
            musicPlayer.playSong(1,i);
        }

        for(int i=1;i<=5;i++){
            musicPlayer.playSong(2,i);
        }

        for(int i=1;i<=10;i++){
            musicPlayer.playSong(3,i);
        }

        musicPlayer.printMostPlayedSongs();
        List<Integer> last3song = musicPlayer.getLastThreeSongs(10);
        for(int song: last3song){
            System.out.println(song);
        }
    }
}
