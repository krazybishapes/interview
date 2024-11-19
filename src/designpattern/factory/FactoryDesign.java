package designpattern.factory;

public class FactoryDesign {


    public static void main(String[] args) {
        ParserFactory parserFactory = new ParserFactory();
        Parser parser = parserFactory.getParserInstance("HTML");
        parser.parse();
    }
}
