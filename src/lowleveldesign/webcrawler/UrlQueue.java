package lowleveldesign.webcrawler;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class UrlQueue {

    private static UrlQueue urlQueueInstance = null;
    private final Queue<String> queue;

    private UrlQueue(){
        queue = new LinkedBlockingQueue<>();
    }

    public static synchronized UrlQueue getInstance(){
        if(urlQueueInstance == null){
            urlQueueInstance = new UrlQueue();
        }

        return urlQueueInstance;
    }

    public void enqueue(String url){
        if(!queue.contains(url)){
            queue.add(url);
        }
    }

    public String dequeue(){
        if(!queue.isEmpty()){
            return queue.poll();
        }

        return null;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
