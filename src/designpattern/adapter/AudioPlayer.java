package designpattern.adapter;

public class AudioPlayer implements MediaPlayer{

    MediaPlayerAdapter adapter;

    @Override
    public void play(String media) {
        if("mp3".equals(media)){
            System.out.println("playing mp3");
        }else if("audio".equals(media) || "video".equals(media)){
            adapter = new MediaPlayerAdapter(media);
            adapter.play(media);
        }
    }
}
