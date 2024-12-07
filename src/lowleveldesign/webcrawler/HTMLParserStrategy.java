package lowleveldesign.webcrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HTMLParserStrategy implements ParserStrategy{

    @Override
    public List<String> parse(String content) {

            List<String> urls = new ArrayList<>();
            if (content.contains("http://example.com/page1")) {
                urls.add("http://example.com/page1");
            }
            return urls;


    }
}
