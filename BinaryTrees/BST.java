

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {

    @SuppressWarnings("unused")
    public class Node {
        private int  value  ;
        private Node left   ;
        private Node right  ;
        private int  height ;

        public Node (int value){
            this.value = value ;
        }

        public int getValue(){
            return value ;
        }
    }
    
    private Node root ;

    public BST(){

    }

    public int height(Node node){
        if (node == null){
            return -1 ;
        }

        return node.height ;
    }

    public boolean isEmpty(){
        return root == null ;
    }

    public void insert (int value) {

        root = insert(root , value);


    }

    private Node insert (Node node , int value ){

        if (node == null){
            node = new Node(value);
            return node ;
        }
        if (value < node.value){

            node.left = insert(node.left , value);
        }

        if (value > node.value){

            node.right = insert(node.right , value);
        }
        node.height = Math.max(height(node.left) , height(node.right)) + 1;
        return node ;
    }

    public void populate (int[] nums){
        for (int i = 0; i < nums.length; i++) {

            this.insert(nums[i]);
            
        }
    }

    public void populatedSorted(int[] nums){
        populatedSorted(nums , 0 , nums.length);


    }

    private void populatedSorted(int[] nums , int start , int end){
        if (start >= end){
            return ;
        }
        int mid = (start + end) / 2 ;

        this.insert(nums[mid]) ;
        populatedSorted(nums , start ,  mid );
        populatedSorted(nums , mid + 1 , end);
    }
 
    












    
    public void display(){
        display(root, "Root Node :");
    }

    private void display (Node node , String details){
        if (node == null){
            return;
        }

        System.out.println(details + node.getValue());

        display(node.left , "Left child of " + node.getValue() + " : ");
        display(node.right , "right child of " + node.getValue() + " : ");
    }
    public void levelOrder(){
        System.out.println(levelOrder(root));
    }

    private List<List<Integer>> levelOrder (Node root){

        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result ;
        }

        Queue<Node> queue = new LinkedList<>();

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {

                Node currentNode = queue.poll() ;
                currentLevel.add(currentNode.value);
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }             
            }

            result.add(currentLevel);
        }
        return result ;

    }
}
