package designpattern.decorator;

public abstract class CofeeDecorator implements Cofee{

    Cofee cofee;

    public CofeeDecorator(Cofee cofee){
        this.cofee = cofee;
    }

    public int getCost(){
        return cofee.getCost();
    }
}
