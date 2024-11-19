package designpattern.decorator;

public class Milk extends CofeeDecorator{
    public Milk(Cofee cofee) {
        super(cofee);
    }

    @Override
    public int getCost(){
        return super.cofee.getCost()+5;
    }
}
