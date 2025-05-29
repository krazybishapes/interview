package Rippling;


import java.util.Arrays;
import java.util.HashMap;
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

class Node<k,v>{
    k key;
    v value;
    Node<k,v> next;

    public Node(){}

    public Node(k key, v value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class MyHashMap<k,v> {

   Node<k,v>[] buckets;
   int capacity;
   int size;

   public MyHashMap(){
       this.capacity=16;
       this.buckets = (Node<k, v>[]) new Node[this.capacity];
       for(int i=0;i<capacity;i++){
           buckets[i] = new Node<>();
       }
   }

   private int hash(k key){
       return key.hashCode() % capacity;
   }

   public void put(k key, v value){
       int index = hash(key);
       Node<k,v> current = buckets[index];
       while (current!=null){
            if(key.equals(current.key)){
                current.value = value;
                return;
            }
           current = current.next;
       }
       current = new Node<>(key,value);
   }

   public v get(k key){
       int index = hash(key);
       Node<k,v> current =  buckets[index];
       while (current!=null){
           if(current.key == key){
               return current.value;
           }
           current = current.next;
       }
      return  null;
   }

    public boolean remove(k key){
        int index = hash(key);
        Node<k,v> current =  buckets[index];
        Node<k,v> prev = null;
        while (current!= null){
            if(key.equals(current.key)){
                if(prev == null){
                    buckets[index] = current.next;
                }else{
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }



}



