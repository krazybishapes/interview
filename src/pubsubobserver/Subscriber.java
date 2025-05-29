package pubsubobserver;

public interface Subscriber {

    public void attach(Consumer consumer);
    public void detach(Consumer consumer);
    public void releaseMessage(Message message);
}
