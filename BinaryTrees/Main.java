

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private class Node{
        int data ;
        Node left ;
        Node right ;

        public Node (int data){
            this.data = data ;
        }
    }

    public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
       
    //    BinaryTree tree = new BinaryTree();
    //    tree.populate(scanner);
    //    //tree.display();
    //    tree.inOrder();


    // BST tree = new BST();
    // int[] nums = {5,2,7,1,4,6,9,8,3,10};
    // tree.populate(nums);
    // tree.display();
    // tree.levelOrder();



    // AVL tree = new AVL();

    // for (int i = 0; i < 1000; i++) {

    //     tree.insert(i);
        
    // }

    // System.out.println(tree.height());


    Queue<Node> queue = new LinkedList<>() ;
    //Node val  = new Node(9);
    //queue.add(val);
   

    System.out.println(queue.isEmpty());


       

    }
    
}
