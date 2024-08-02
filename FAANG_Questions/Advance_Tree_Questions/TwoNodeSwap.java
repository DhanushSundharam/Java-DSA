package Advance_Tree_Questions;

public class TwoNodeSwap { 

    Node first ;
    Node second ;
    Node prev ;


    public void helper (Node root){
        iot(root);

        //swap
        int temp = first.value ;
        first.value = second.value ;
        second.value = temp ;
    }

    private void iot(Node node){
        if (node == null){
            return ;
        }

        iot(node.left);

        if (prev!= null && prev.value > node.value){

            if (first == null){
                first = prev ;
            }

            second = node ;

        }

        prev = node ;



        iot(node.right);
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
