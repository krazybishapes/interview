package Rippling;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Rippling1<K,V> {



    private Map<K, V> cache = null;
    private Stack<Map<K,V>> transactionStack = null;


    public void begin(){
        transactionStack.add(new HashMap<>());
    }

    public Rippling1(){
        cache = new HashMap<>();
        transactionStack = new Stack<>();
    }

    public V get(K key){

        if(!transactionStack.isEmpty()){
            for(Map<K,V> transaction: transactionStack){
                if(transaction.containsKey(key)){
                    return transaction.get(key);
                }
            }
        }
        return cache.get(key);

    }

    public void set(K key, V value){
        if(transactionStack.isEmpty()){
            cache.put(key,value);
            return;
        }
        Map<K,V> topTransaction = transactionStack.peek();
        topTransaction.put(key, value);

    }

    public  void remove(K key){
        if(transactionStack.isEmpty()){
            cache.remove(key);
            return;
        }

        Map<K,V> transaction = transactionStack.peek();
        transaction.put(key, null);

    }

    public boolean commit(){
        if(transactionStack.isEmpty()) return false;

        Map<K,V> top = transactionStack.peek();
        for(Map.Entry<K,V> entry: top.entrySet()){
            if(entry.getValue()==null){
                top.remove(entry.getKey());
            }else{
                cache.put(entry.getKey(), entry.getValue());
            }
        }

        return true;
    }

    public boolean rollback(){
        if(transactionStack.isEmpty()) return false;
        transactionStack.pop();
        return true;

    }

    public static void main(String[] args) {
        Rippling1<String,String> store = new Rippling1<>();

        store.set("a", "1");
        System.out.println(store.get("a")); // 1

        store.begin();
        store.set("a", "2");
        System.out.println(store.get("a")); // 2

        store.rollback();
        System.out.println(store.get("a")); // 1

        store.begin();
        store.set("a", "3");
        store.commit();
        System.out.println(store.get("a"));
    }
}
