package designpattern.adapter;

public class AdapterDemo {

    public static void main(String[] args) {
       AudioPlayer audioPlayer = new AudioPlayer();

       audioPlayer.play("mp3");
       audioPlayer.play("audio");
       audioPlayer.play("video");
    }
}
