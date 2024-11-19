package designpattern.adapter;

public class AudioMediaPlayer implements AdvanceMediaPlayer{
    @Override
    public void playAudio() {
        System.out.println("Playing Audio");
    }

    @Override
    public void playVideo() {
        //do nothing
    }
}
