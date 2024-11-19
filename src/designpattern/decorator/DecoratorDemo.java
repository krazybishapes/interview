package designpattern.decorator;

public class DecoratorDemo {


    public static void main(String[] args) {
        Cofee cofee = new Latte();

        System.out.println("Cofee cost:"+cofee.getCost());

        cofee = new Milk(cofee);
        System.out.println("Cofee cost:"+cofee.getCost());
    }
}
