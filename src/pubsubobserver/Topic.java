package pubsubobserver;

public class Topic {

    private String name;

    private Subscribers subscribers;

    public Topic(String name){
        this.name = name;
    }

    public Topic(String name, Subscribers subscribers){
        this.name = name;
        this.subscribers = subscribers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subscribers getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Subscribers subscribers) {
        this.subscribers = subscribers;
    }
}
