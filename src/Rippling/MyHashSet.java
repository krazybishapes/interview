package Rippling;


import java.util.LinkedList;
import java.util.List;

/**
 * Design HashSet
 *
 * functional requirement
 * get(key) K
 * contains(key) boolean
 * remove(key) boolean
 *
 * Non functional requirement
 * Highly scalable to keep n number of records
 * Highly performant in getting the element- O(1)
 * Highly available(asssuming memory is not a constraint)
 *
 *
 * Approach 1
 * vertical scaling
 * keep element in link & do chaining(not contiguos memeory)
 * Issue- operation time complexity-O(n) in worst case
 *
 *
 * Approach 2
 * Hashing(Horizontal scaling)
 * Hash on key to find the index of element
 * collision- in case of hash collision, do chaining(Bucket)
 * Operation-O(n/k) in worst case, better than O(n). On average O(1)
 * What should be the ideal bucket size?
 * to fix-even distribution
 * Approach 1
 * Prime numbers- too less factors
 * Issue - size can grow even bigger even though we dont need that much size
 * Approach 2
 * take size power of 2
 * index = key &(size-1), bit operator work correctly with power of 2
 * and can control size better than prime numbers
 *
 * Ideal size of bucket and resizing
 * do not take too much and too low at start. 16 is an ideal number
 *
 *
 * resiging
 * load factor = 0.75
 * resize to double size of current set if reached threshold of 75%, size> capacity * load factor
 *
 * rehashing post resiging
 * Rehashing- O(n)
 */

class Bucket<k>{
    private List<k> container;

    public Bucket(){
        this.container = new LinkedList<>();
    }

    public void insert(k key){
        int index = this.container.indexOf(key);
        if(index == -1){
            this.container.addFirst(key);
        }
    }

    public k get(k key){
        int index = this.container.indexOf(key);
        if(index == -1){
            return null;
        }
        return this.container.get(index);
    }

    public boolean remove(k key){
        return this.container.remove(key);
    }

    public boolean contains(k key){
        int index = this.container.indexOf(key);
        if(index == -1){
            return false;
        }
        return true;
    }

}

class Solution1{

    public static void main(String[] args) {

        MyHashSet set = new MyHashSet(10);
        set.insert(10);
        if(set.contains(10)){
            set.insert(20);
        }
        System.out.println(set.size());
        set.remove(10);
        System.out.println(set.size());
    }

}
public class MyHashSet {

    private int capacity;
    private int size;
    private Bucket<Integer>[] buckets;

    private static final int DEFAULT_CAPACITY= 16;

    public MyHashSet(){
        this.capacity = DEFAULT_CAPACITY;
        buckets = new Bucket[capacity];
        for(int i=0;i<capacity;i++){
            buckets[i] = new Bucket<>();
        }
        this.size = 0;
    }

    public MyHashSet(int capacity){
        this();
        this.capacity = capacity;

    }

    private int hash(int key){
        return key%capacity;
    }

    public void insert(int key){
        int index = hash(key);
        Bucket<Integer> bucket = buckets[index];
        bucket.insert(key);
        size++;
    }

    public int get(int key){
        int index = hash(key);
        Bucket<Integer> bucket = buckets[index];
        return bucket.get(key);
    }

    public boolean remove(int key){
        int index = hash(key);
        Bucket<Integer> bucket = buckets[index];
        size--;
        return bucket.remove(key);
    }

    public boolean contains(int key){
        int index = hash(key);
        Bucket<Integer> bucket = buckets[index];
        return bucket.contains(key);
    }

    public int size(){
        return this.size;
    }



}



