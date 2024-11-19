package designpattern.builder;

public interface MyBuilder {

    MyBuilder id(int id);
    MyBuilder name(String name);
    MyBuilder colour(String colour);
    MyBuilder engine(String engine);

}
