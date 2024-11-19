package designpattern.builder;

public class BuilderMain {

    public static void main(String[] args) {
        Car car = new CarBuilder()
                .id(1)
                .name("Maruti")
                .colour("red")
                .engine("100 CC")
                .build();

        System.out.println(car.toString());
    }
}
