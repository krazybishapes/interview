package lowleveldesign.webcrawler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WebCrawler {

    static final UrlQueue urlQueue = UrlQueue.getInstance();
    static HTTPClient httpClient = HTTPClientFactory.createClient();
    static ParserStrategy parserStrategy = new HTMLParserStrategy();
    static CrawlObserver crawlObserver = new ConsoleObserver();

    public static void main(String[] args){


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        AtomicInteger activetask = new AtomicInteger(0);

        urlQueue.enqueue("https://example.com");
        activetask.incrementAndGet();

        executorService.execute(()-> {
            try {
                execute();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        while(activetask.get()>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executorService.shutdown();

    }

    private static void execute() throws InterruptedException {
        while(!urlQueue.isEmpty()){

            String url = urlQueue.dequeue();

            CrawlCommand crawlCommand = new CrawlCommand(url,httpClient, parserStrategy, crawlObserver);

            crawlCommand.execute();

            Thread.sleep(1000);
        }
    }
}
