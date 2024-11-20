package ProducerConsumer;

public class PorducerConsumer{

    public static void main(String[] args) throws InterruptedException {
        SharedBuffer sharedBuffer = new SharedBuffer(10);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    sharedBuffer.produce(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while(true){
                    sharedBuffer.consume();
                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();



    }
}
