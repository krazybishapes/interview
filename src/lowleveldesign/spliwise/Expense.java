package lowleveldesign.spliwise;

public class Expense {

    double amount;
    User user;

    public Expense(User user, double amount){
        this.user = user;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
