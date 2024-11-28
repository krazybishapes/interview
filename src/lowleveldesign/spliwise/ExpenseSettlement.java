package lowleveldesign.spliwise;

public class ExpenseSettlement {

    ExpenseSettlementStrategy expenseSettlementStrategy;

    public ExpenseSettlement(ExpenseSettlementStrategy expenseSettlementStrategy){
        this.expenseSettlementStrategy = expenseSettlementStrategy;
    }

    public void settleAmount(double amount, User spender, User ower){
        this.expenseSettlementStrategy.settleExpense(amount,spender,ower);
    }
}
