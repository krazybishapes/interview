package designpattern.strategy;

public class ShoppingCartPayment {

    PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy payment){
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount){
        this.paymentStrategy.pay(amount);
    }


}
