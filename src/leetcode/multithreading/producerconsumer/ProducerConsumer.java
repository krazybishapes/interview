package leetcode.multithreading.producerconsumer;

public class ProducerConsumer {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(10);

        Thread producer = new Thread(()->{
            try {
            for(int i =0;i<100;i++){
                sharedResource.produce(i);
                Thread.sleep(500);
            }


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(()->{
            while(true){
               int i =  sharedResource.consume();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        producer.start();
        consumer.start();
    }

}
