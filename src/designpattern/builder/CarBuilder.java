package designpattern.builder;

public class CarBuilder implements MyBuilder{

    int id;
    String name;
    String colour;
    String engine;

    @Override
    public CarBuilder id(int id){
        this.id = id;
        return this;
    }

    @Override
    public CarBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CarBuilder colour(String colour) {
        this.colour = colour;
        return this;
    }

    @Override
    public CarBuilder engine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car build(){
        return new Car(this);
    }





}
