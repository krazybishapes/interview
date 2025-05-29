package pubsubobserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopicServiceImpl {

    //use map
    Set<Topic> topics;

    public TopicServiceImpl(){
        this.topics = new HashSet<>();
    }

    public Topic createTopic(String name){
        Topic topic = new Topic(name);
        this.topics.add(topic);
        return topic;
    }

    public Topic getTopic(String name){

            for(Topic topic: topics){
                if(name.equals(topic.getName())){
                    return topic;
                }
            }

        return null;
    }
}
