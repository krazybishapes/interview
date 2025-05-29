package Rippling;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TransactionableCache extends Cache{
    Stack<Map<String,String>> transactionStack;


    public TransactionableCache(){
        super();
        transactionStack = new Stack<>();
    }

    public void begin(){
        //System.out.println("transaction stack created");
        transactionStack.add(new HashMap<>());
    }

    public boolean commit(){
        //Single transaction stack
            /*if(transactionStack.isEmpty()) return false;

            for(Map.Entry<String,String> entry: transactionStack.peek().entrySet()){
                if(entry.getValue()==null){
                    super.remove(entry.getKey());
                }else{
                    super.put(entry.getKey(), entry.getValue());
                }
            }
            return true;*/
        //Nested transaction
        if(transactionStack.isEmpty()) return false;
        Map<String, String> top = transactionStack.pop();
        if(transactionStack.isEmpty()){
            for(Map.Entry<String,String> entry: top.entrySet()){
                if(entry.getValue()==null){
                    super.remove(entry.getKey());
                }else{
                    super.put(entry.getKey(), entry.getValue());
                }
            }

        }else{
            Map<String,String> peek = transactionStack.pop();
            peek.putAll(top);
        }
        return true;
    }

    public boolean rollback(){
        if(transactionStack.isEmpty()){
            throw new IllegalStateException("No transaction found");
        }
        transactionStack.pop();
        return true;
    }

    public String get(String key){

        for(int i= transactionStack.size()-1;i>=0;i--){
            Map<String,String> stack = transactionStack.get(i);
            //System.out.println("In get"+stack.containsKey(key));
            if(stack.containsKey(key)){
                return stack.get(key);
            }
        }



        return super.get(key);
    }

    public void put(String key, String value){
        if(transactionStack.isEmpty()){
            super.put(key,value);
            return;
        }

        transactionStack.peek().put(key, value);
    }

    public boolean remove(String key){
        if(transactionStack.isEmpty()){
            super.remove(key);
            return true;
        }

        transactionStack.peek().put(key, null);
        return true;
    }


}