package lowleveldesign.spliwise;

import java.util.HashMap;
import java.util.Map;

public class SplitWiseTest {

    Map<String, Map<String,Integer>> ledger = new HashMap<>();
    public static void main(String[] args) {

        SplitWiseTest splitwise = new SplitWiseTest();

        // Add transactions
        splitwise.addTransaction("a", "b", 200); // a pays b 200
        splitwise.addTransaction("b", "c", 300); // b pays c 300
        splitwise.addTransaction("b", "a", 100); // b pays a 100

        // Query debts
        System.out.println("Debts:");
        splitwise.printDebts();


    }

    private void addTransaction(String payer, String payee, int amount){

        ledger.putIfAbsent(payee,new HashMap<>());
        ledger.putIfAbsent(payer, new HashMap<>());

        //add ledger of payer to payee
        ledger.get(payer).put(payee, ledger.get(payer).getOrDefault(payee,0)+amount);
        //add ledger of payee to payee
        ledger.get(payee).put(payer, ledger.get(payee).getOrDefault(payer,0)-amount);

        //nullify zero values
        if(ledger.get(payee).get(payer)==0) ledger.get(payee).remove(payer);
        if(ledger.get(payer).get(payee)==0) ledger.get(payer).remove(payee);


    }

    private void printDebts(){
        for(String person: ledger.keySet()){
            for(String owesTo: ledger.get(person).keySet()){

                int amount = ledger.get(person).get(owesTo);
                if (amount > 0) {
                    System.out.println(person + " owes " + owesTo + ": " + amount);
                }
            }
        }
    }



}
