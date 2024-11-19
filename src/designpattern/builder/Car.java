package designpattern.builder;

public class Car {

    private int id;
    private String name;
    private String colour;
    private String engine;

    public Car(CarBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.colour = builder.colour;
        this.engine = builder.engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
