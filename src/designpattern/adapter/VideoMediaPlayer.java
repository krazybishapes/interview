package designpattern.adapter;

public class VideoMediaPlayer implements AdvanceMediaPlayer{
    @Override
    public void playAudio() {
        //do nothing
    }

    @Override
    public void playVideo() {
        System.out.println("Playing Video");
    }
}
