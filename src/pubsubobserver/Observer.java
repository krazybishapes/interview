package pubsubobserver;

public interface Observer {

    public void consumeMessage(Message message);
}
