package lowleveldesign.webcrawler;

import java.util.List;

public interface ParserStrategy {

    public List<String> parse(String content);
}
