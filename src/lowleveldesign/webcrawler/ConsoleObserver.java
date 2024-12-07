package lowleveldesign.webcrawler;

public class ConsoleObserver implements CrawlObserver{


    @Override
    public void onUrlProcessed(String url) {
        System.out.println("New Url processed");
    }
}
