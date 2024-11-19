package ThreadPool;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPool(5,15);

        for(int i=0;i<50;i++){
            int task = i+1;
            try {
                threadPool.execute(() -> {
                    System.out.println("Thread Running:" + Thread.currentThread().getName() + " " + task);
                });
                Thread.sleep(100);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        threadPool.stop();
    }
}
