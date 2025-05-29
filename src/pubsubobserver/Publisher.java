package pubsubobserver;

import java.util.Objects;

public class Publisher {

    TopicServiceImpl topicService;

    public Publisher(TopicServiceImpl topicService){
        this.topicService = topicService;
    }

    public void publishMessage(String topicName, Message message){

        Topic topic = this.topicService.getTopic(topicName);
        if(Objects.nonNull(topic)){

            Subscribers subscribers = topic.getSubscribers();
            subscribers.releaseMessage(message);
        }

    }


}
