package Advance_Tree_Questions;

public class DoubleLinkedList {

    LLNode head ;
    LLNode tail ;

    public LLNode convert(Node root){
        if (root == null){
            return null ;
        }

        helper(root);

        return head ;
    }

    private void helper (Node node){
        if (node == null){
            return  ;
        }
        helper(node.left);

        LLNode newNode =new LLNode(node.value);

        if (head == null){
            head = newNode ;
            tail =newNode ;
        }else {
            tail.next = newNode ;
            newNode.prev = tail ;
            tail = newNode ;
        }


        helper(node.right);
    }

    private class LLNode {
        int value ;
        LLNode prev ;
        LLNode next ;

        public LLNode(int value){
            this.value = value ;
        }
    }

    private class Node {
        int value ;
        Node left ;
        Node right ;

        public Node (int value){
            this.value = value ;

        }


    }




    
}
