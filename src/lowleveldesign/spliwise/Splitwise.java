package lowleveldesign.spliwise;

public class Splitwise {

    public static void main(String[] args) {

        User santosh = new User(1,"Santosh");
        Expense expense = new Expense(santosh,200);

        User abhishek = new User(2,"Abhishek");

        ExpenseSettlement expenseSettlement = new ExpenseSettlement(new EqualExpenseStrategy());
        expenseSettlement.settleAmount(expense.getAmount(), santosh, abhishek);
    }
}
