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


        for (int i = 0; i < MAX_THREADS; i++) {
            executorService.submit(() -> {
               crawl(htmlParser,hostName);
            });
        }

        executorService.shutdown();


    }

    private static String getHostName(String startUrl){

        String[] split = startUrl.split("/");
        if(split.length<2){
           return null;
        }
        return split[2];
    }



    private static void crawl(HTMLParser htmlParser, String hostName) {
        while(true){
            String url = queue.poll();
            if(url == null){

                if(resultUrls.size() == queue.size()){
                    break;
                }else{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }


            }else{
                if (resultUrls.contains(url) || !hostName.equals(getHostName(url))) {
                    return;
                }

                resultUrls.add(url);
                List<String> urls = htmlParser.getUrls(url);
                for (String newUrl : urls) {
                    if (!resultUrls.contains(newUrl)) {
                        queue.add(newUrl);
                    }
                }
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



