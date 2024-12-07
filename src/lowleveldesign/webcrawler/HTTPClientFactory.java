package lowleveldesign.webcrawler;

public class HTTPClientFactory {




    public static HTTPClient createClient(){
        return new SimpleHTTPClient();
    }
}
