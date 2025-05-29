package dp;

import java.util.ArrayList;
import java.util.List;

public class MaxRootToLeaf {

    static class Node{
        int data;
        Node left, right;

        public Node(int val){
            this.data = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(6);
        Node left = new Node(2);
        Node right = new Node(4);

        root.left = left;
        root.right = right;

        left = new Node(8);
        root.left.left = left;

        List<Integer> res = new ArrayList<>();

        findMaxRootToLeaf(root,Integer.MIN_VALUE,res);
        res.forEach(System.out::println);




    }

    private static void findMaxRootToLeaf(Node root, int max, List<Integer> result){

        if(root == null){
            return;
        }

        max = Math.max(max, root.data);

        if(root.left == null && root.right== null ){
            result.add(max);
        }


        findMaxRootToLeaf(root.left,max,result);
        findMaxRootToLeaf(root.right,max,  result);



    }
}
