package Advance_Tree_Questions;

import java.util.HashMap;

public class PreIn { 

    class Node {
        int data ;
        Node left ;
        Node right ;

        public Node (int data){
            this.data = data ;
        }
    }


    public Node buildTree (int[] preOrder , int[] inOrder){

        HashMap<Integer , Integer> map = new HashMap<>() ;
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
            
        }

        return helper(preOrder , inOrder , 0 ,preOrder.length-1 ,map);
    }
    int index = 0 ;
    public Node helper(int[] preOrder , int[] inOrder , int left , int right , HashMap<Integer , Integer> map){
        if (left > right){

            return null;


        }

        int current = preOrder[index];
        index++;

        Node node = new Node(current);

        if (left == right){
            return node ;
        }

        node.left = helper(preOrder, inOrder, left, index-1, map);
        node.right = helper(preOrder, inOrder, index+1, right, map);

        return node ;
    }
}
