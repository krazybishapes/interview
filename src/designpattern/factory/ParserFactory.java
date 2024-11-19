package designpattern.factory;

public class ParserFactory {

    public Parser getParserInstance(String type){
        if("text".equals(type)){
            return new TextParser();
        }else if ("HTML".equals(type)){
            return new HTMLParser();
        }

        return null;
    }
}
