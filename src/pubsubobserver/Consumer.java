package pubsubobserver;

public class Consumer implements Observer{

    String name;

    public Consumer(String name){
        this.name = name;
    }

    @Override
    public void consumeMessage(Message message) {

        System.out.println(this.name+":"+message.getContent());
    }
}
