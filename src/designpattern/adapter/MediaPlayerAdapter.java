package designpattern.adapter;

public class MediaPlayerAdapter implements MediaPlayer{

    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaPlayerAdapter(String media){
        if("audio".equals(media)){
            advanceMediaPlayer = new AudioMediaPlayer();
        }else{
            advanceMediaPlayer = new VideoMediaPlayer();
        }
    }
    @Override
    public void play(String media) {
        if("audio".equals(media)){
            advanceMediaPlayer.playAudio();
        }else{
            advanceMediaPlayer.playVideo();
        }
    }
}
