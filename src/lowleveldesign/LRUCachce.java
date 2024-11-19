package lowleveldesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCachce {

    Node head = new Node();
    Node tail = new Node();

    private int capacity;
    private Map<String, Node> cache;


     class Node{
         private String key;
        private String val;
        private Node next;
        private Node prev;

        public Node(){}

        public Node(String key, String val){
            this.key = key;
            this.val = val;
            head.next = tail;
            tail.prev = head;
        }
    }



    public LRUCachce(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

       prevNode.next = nextNode;
       nextNode.prev = prevNode;

    }

    private void addNode(Node node){
         Node tempNode = head.next;
         head.next = node;
         node.prev = head;
         node. next = tempNode;
         tempNode.prev = node;

    }


    public String get(String key){
        Node node = cache.get(key);
        String result = "";
        //if present then remove the node and add to front
        if(node == null){
            return result;
        }else{
            result = node.val;
            removeNode( node);
            addNode( node);
        }

        return result;
    }

    public void put(String key, String value){
         Node node = cache.get(key);
         //if present, then remove node and update value and add node
         if(node != null){
            //remove and update value
             removeNode(node);
             node.val = value;
             addNode(node);
         }else{
             //if capacity breached
             if(cache.size() == this.capacity){
                 cache.remove(tail.prev.key);
                 removeNode(tail.prev);
             }

             //if not present, add node to front
             node = new Node(key,value);
             cache.put(key,node);
             addNode(node);

         }
    }





}

