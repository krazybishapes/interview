package leetcode.multithreading;

import java.util.*;
import java.util.concurrent.*;

public class WebCrawler {



    static Set<String> resultUrls = ConcurrentHashMap.newKeySet();
    static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    static int RATE_LIMIT_PER_SECOND = 5;
    static long interval_in_ms = 1000/RATE_LIMIT_PER_SECOND;
    static int MAX_THREADS = 10;

    public static void main(String[] args) {

        String startUrl="https://google.com";
        String hostName = getHostName(startUrl);
        if(hostName == null || hostName.length()==0){
            System.out.println("Invalid host name");
            return;
        }
        queue.offer(startUrl);
        HTMLParser htmlParser = new DummyHTMLParser();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //ScheduledExecutorService rateLimiter = Executors.newSingleThreadScheduledExecutor();

        for (int i = 0; i < MAX_THREADS; i++) {
            executorService.submit(() -> {
                while (true) {
                    String url = queue.poll();
                    if (url == null) {
                        // Exit loop if queue is empty and no new tasks are pending
                        if (resultUrls.size() == queue.size()) {
                            break;
                        } else {
                            // Sleep briefly to allow other threads to populate the queue
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                break;
                            }
                        }
                    } else {
                        crawl(url,htmlParser, hostName);
                    }
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        //rateLimiter.shutdown();

    }

    private static String getHostName(String startUrl){

        String[] split = startUrl.split("/");
        if(split.length<2){
           return null;
        }
        return split[2];
    }

    /*private static void crawl(HTMLParser htmlParser, String hostName,ScheduledExecutorService rateLimiter){

        while(!queue.isEmpty()){
            String currentUrl = queue.poll();
            if(currentUrl == null || resulturls.contains(currentUrl) || !hostName.equals(getHostName(currentUrl))){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                ///rateLimiter.schedule(()->{

                    resulturls.add(currentUrl);
                    System.out.println(" Thread:" + Thread.currentThread().getName() +" Crawling: "+ currentUrl );
                    List<String> urls = htmlParser.getUrls(currentUrl);
                    for(String url:urls){
                        if(url == null || resulturls.contains(url) || !hostName.equals(getHostName(url))){
                            continue;
                        }
                        queue.offer(url);

                    }


               // },interval_in_ms,TimeUnit.MILLISECONDS).get();
            } finally {

            }


        }*/

    private static void crawl(String startUrl, HTMLParser htmlParser, String hostName) {
        if (resultUrls.contains(startUrl) || !hostName.equals(getHostName(startUrl))) {
            return;
        }

        resultUrls.add(startUrl);
        List<String> urls = htmlParser.getUrls(startUrl);
        for (String url : urls) {
            if (!resultUrls.contains(url)) {
                queue.add(url);
            }
        }
    }




    }






    interface HTMLParser{
        public List<String> getUrls(String startUrl);
    }

    class DummyHTMLParser implements HTMLParser {
        @Override
        public List<String> getUrls(String startUrl) {
            // Simulate fetching URLs
            System.out.println("Thread"+ Thread.currentThread().getName()+"Fetching URLs from: " + startUrl);
            return List.of(startUrl + "/page1", startUrl + "/page2", startUrl + "/page3");
        }
    }



