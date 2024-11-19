package designpattern.factory;

public class HTMLParser implements Parser {
    @Override
    public void parse() {
        System.out.println("Parsing HTML");
    }
}
