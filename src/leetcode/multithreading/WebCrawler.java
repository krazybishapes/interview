package leetcode.multithreading;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WebCrawler {

    static class DummyHTMLParser implements HTMLParser {
        @Override
        public List<String> getUrls(String startUrl) {
            // Simulate fetching URLs
            System.out.println("Fetching URLs from: " + startUrl);
            return List.of(startUrl + "/page1", startUrl + "/page2", startUrl + "/page3");
        }
    }

    static Set<String> resulturls = ConcurrentHashMap.newKeySet();

    static interface HTMLParser{
        public List<String> getUrls(String startUrl);
    }

    public static void main(String[] args) {

        String startUrl="https://google.com";
        String hostName = getHostName(startUrl);
        System.out.println(hostName);
        HTMLParser htmlParser = new DummyHTMLParser();

        //dfs(startUrl,htmlParser,hostName);


    }

    private static String getHostName(String startUrl){

        String[] split = startUrl.split("/");
        if(split.length<2){
           return null;
        }
        return split[2];
    }

    private static void dfs(String startUrl, HTMLParser htmlParser, String hostName){

        List<String> urls = htmlParser.getUrls(startUrl);

        for(String url:urls){
            if(resulturls.contains(url) || !hostName.equals(getHostName(url))){
                continue;
            }
            resulturls.add(url);
            dfs(url,htmlParser,hostName);
        }
    }


}
