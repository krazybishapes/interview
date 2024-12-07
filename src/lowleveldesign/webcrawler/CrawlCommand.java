package lowleveldesign.webcrawler;

import java.util.List;

public class CrawlCommand {

    String url;
    HTTPClient httpClient;
    ParserStrategy parserStrategy;
    CrawlObserver crawlObserver;

    public CrawlCommand(String url,HTTPClient httpClient,
                        ParserStrategy parserStrategy, CrawlObserver crawlObserver){
        this.httpClient = httpClient;
        this.parserStrategy = parserStrategy;
        this.url = url;
        this.crawlObserver = crawlObserver;
    }


    public void execute(){
        String content = httpClient.sendRequest(url);
        List<String> urls = parserStrategy.parse(content);
        UrlQueue urlQueue = UrlQueue.getInstance();
        for(String url: urls){
            urlQueue.enqueue(url);
        }

        crawlObserver.onUrlProcessed(url);

    }
}
