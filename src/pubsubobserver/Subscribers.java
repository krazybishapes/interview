package pubsubobserver;

import java.util.ArrayList;
import java.util.List;

public class Subscribers implements Subscriber{

    List<Observer> observerList = new ArrayList<>();
    @Override
    public void attach(Consumer consumer) {
        observerList.add(consumer);
    }

    @Override
    public void detach(Consumer consumer) {
        observerList.remove(consumer);
    }

    @Override
    public void releaseMessage(Message message) {
        for(Observer observer: observerList){
            observer.consumeMessage(message);
        }
    }
}
