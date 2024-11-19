package designpattern.factory;

public class TextParser implements Parser {
    @Override
    public void parse() {
        System.out.println("Parsing text");
    }
}
