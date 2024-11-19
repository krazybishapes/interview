package designpattern.strategy;

public class StrategyDemo {
    public static void main(String[] args) {

        ShoppingCartPayment shoppingCartPayment = new ShoppingCartPayment();


        shoppingCartPayment.setPaymentStrategy(new CreditCardPayment());
        shoppingCartPayment.checkout(100);


        shoppingCartPayment.setPaymentStrategy(new DebitCardPayment());
        shoppingCartPayment.checkout(100);
    }
}
