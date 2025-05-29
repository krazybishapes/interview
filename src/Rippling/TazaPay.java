package Rippling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TazaPay {

    static class Transaction{
        String from;
        String to;
        Double amount;

        public Transaction(String from, String to, Double amount){
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

    }

    public static void main(String[] args) {

      List<Transaction> transactionList = new ArrayList<>();
      transactionList.add(new Transaction("santosh","preety", 100.00)); //santosh=-100, preety=100
      transactionList.add(new Transaction("preety","santosh", 50.00));// sanotsh=-50, preety= 50
      transactionList.add(new Transaction("preety","sandeep", 100.00));
      transactionList.add(new Transaction("sandeep","santosh", 100.00));

      Map<String, Map<String, Double>> userLedger = new HashMap<>();

      for(Transaction transaction: transactionList){
          doSettlement(transaction, userLedger);
      }
        System.out.println(userLedger.size());

        for (Map.Entry<String, Map<String, Double>> userEntry : userLedger.entrySet()) {

            Map<String, Double> ledger = userEntry.getValue();
            for(Map.Entry<String,Double> entry: ledger.entrySet()){


                System.out.println(userEntry.getKey()+" need to settle with " + entry.getKey()+ " amount "+ entry.getValue());

            }

        }


    }

    private static void doSettlement(Transaction transaction, Map<String, Map<String, Double>> userLedger) {
        String user1 = transaction.from;
        String user2 = transaction.to;
        Double amount = transaction.amount;
        Map<String, Double> ledgerUser1 = userLedger.get(user1);
        Map<String, Double> ledgerUser2 = userLedger.get(user2);
        if(ledgerUser1 == null){
            ledgerUser1 = new HashMap<>();
        }
        if(ledgerUser2 == null){
            ledgerUser2 = new HashMap<>();
        }

        //user1 take from user2
        ledgerUser1.put(user2, ledgerUser1.getOrDefault(user2, 0.0)+amount);
        //System.out.println(user2 +" " +ledgerUser1.get(user2));
        //user2 give to user1
        ledgerUser2.put(user1, ledgerUser2.getOrDefault(user1, 0.0)-amount);
        userLedger.put(user1,ledgerUser1);
        userLedger.put(user2,ledgerUser2);


    }


}
