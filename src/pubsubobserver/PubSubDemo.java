package pubsubobserver;

public class PubSubDemo {



    public static void main(String[] args) {
        TopicServiceImpl topicService = new TopicServiceImpl();
        Topic topic = topicService.createTopic("Topic-1");

        Subscribers subscribers = new Subscribers();
        subscribers.attach(new Consumer("Consumer-0"));
        subscribers.attach(new Consumer("Consumer-1"));
        topic.setSubscribers(subscribers);

        Publisher publisher = new Publisher(topicService);

        publisher.publishMessage("Topic-1", new Message("Hello"));

    }
}
