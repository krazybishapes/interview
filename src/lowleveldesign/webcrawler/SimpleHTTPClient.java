package lowleveldesign.webcrawler;

public class SimpleHTTPClient extends HTTPClient {
    @Override
    public String sendRequest(String url) {
        return "<html><head><title>Sample Page</title></head><body><a href=\"http://example.com/page1\">Link</a></body></html>";

    }
}
