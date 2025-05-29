package Rippling;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Cache {

    Map<String, String> backstore;

    public Cache(){
        backstore = new HashMap<>();
    }

    public String get(String key){
        if(!backstore.containsKey(key)){
            return null;
        }
        return backstore.get(key);
    }

    public void put(String key, String value){
        backstore.put(key, value);
    }

    public boolean remove(String key){
        if(!backstore.containsKey(key)){
            return false;
        }
       backstore.remove(key);
       return true;
    }

    public boolean update (String key, String value){
        if(!backstore.containsKey(key)){
            return false;
        }
        backstore.put(key, value);
        return true;
    }




    public static void main(String[] args) {
        TransactionableCache cache = new TransactionableCache();

        cache.put("a", "1");
        System.out.println("Test1:"+ cache.get("a")); // 1

        cache.begin(); // start transaction 1
        cache.put("a", "2");
        System.out.println("Test2:"+cache.get("a")); // 2

        cache.begin(); // start transaction 2
        cache.put("a", "3");
        System.out.println("Test3:"+cache.get("a")); // 3

        cache.rollback(); // rollback transaction 2
        System.out.println("Test4:"+cache.get("a")); // 2

        cache.commit(); // commit transaction 1
        System.out.println("Test5:"+cache.get("a")); // 2

        cache.rollback(); // should fail, no active transaction
    }
}
