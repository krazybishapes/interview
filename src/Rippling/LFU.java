package Rippling;

import java.util.*;

class Pair{
    int frequency;
    int value;

    public Pair(int value, int frequency){
        this.frequency = frequency;
        this.value = value;
    }
}

public class LFU {

    int capacity;
    int min;
    Map<Integer, Pair> cache;
    Map<Integer, LinkedHashSet<Integer>> freqs;

    public LFU(int capacity){
        this.capacity = capacity;
        this.min = 0;
        cache = new HashMap<>();
        freqs = new HashMap<>();
    }

    public int get(int key){
        if(cache.get(key) == null){
            return -1;
        }
        Pair pair = cache.get(key);
        remove(key, pair.frequency);
        insert(key, pair.value, pair.frequency+1);
        return pair.value;
    }

    public void put(int key, int value){
        if(cache.get(key) != null){
            cache.put(key, new Pair(value, cache.get(key).frequency));
            get(key);
            return;
        }

        handleCapacityBreach();
        insert(key,value, 1);
    }

    private void handleCapacityBreach() {
        //if capacity breached, then remove LFU or it ties, LRU
        if(capacity == cache.size()){
            Set<Integer> keys = this.freqs.get(min);
            int keyDelete = keys.iterator().next();
            keys.remove(keyDelete);
            cache.remove(keyDelete);
            if(keys.isEmpty()){
                this.freqs.remove(min);
            }
            min =1;

        }
    }

    private void remove(int key, int frequency){
        Set<Integer> keys = this.freqs.get(frequency);
        keys.remove(key);
        if(keys.isEmpty()){
            this.freqs.remove(frequency);
            if(min == frequency){
                ++min;
            }
        }
    }

    private void insert(int key, int value, int frequency){
        this.freqs.computeIfAbsent(frequency,k-> new LinkedHashSet<>()).add(key);
        this.cache.put(key,new Pair(value,frequency));
    }


}
