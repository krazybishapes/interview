package designpattern.decorator;

public class Sugar extends CofeeDecorator{
    public Sugar(Cofee cofee) {
        super(cofee);
    }

    public int cost(){
        return super.cofee.getCost()+10;
    }
}
