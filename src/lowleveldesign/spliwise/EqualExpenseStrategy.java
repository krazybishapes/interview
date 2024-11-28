package lowleveldesign.spliwise;

public class EqualExpenseStrategy implements ExpenseSettlementStrategy{
    @Override
    public void settleExpense(double amount, User spender, User ower) {

        double amounTobeSettled = amount/2;

        ower.setBalance(ower.getBalance()-amounTobeSettled);

    }
}
