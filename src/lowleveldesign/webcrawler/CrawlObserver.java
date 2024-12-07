package lowleveldesign.webcrawler;

public interface CrawlObserver {

    void onUrlProcessed(String url);
}
