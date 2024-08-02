

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    public BinaryTree(){

    }

    private static class Node {
        int value ;
        Node left ;
        Node right ;

        public Node (int value){
            this.value = value ;
        }
    }
   
    private Node root ;

    //insert elements 
    public void populate(Scanner scanner){
        System.out.println("Enter the Root Node :");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner , root);
    }

    private void populate (Scanner scanner , Node node){
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.println("Enter the value of the left " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner , node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right){
            System.out.println("Enter the value of the right " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner , node.right);
        }
    }

    public void display(){
        display(root , "");
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null){
            return ;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null){
            return ;
        }
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null){
            return ;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    private void display(Node node , String indent){
        if (node == null){
            return ;
        }
        System.out.println(indent + node.value); 
        display(node.left , indent + "\t");
        display(node.right , indent + "\t");
    }

    public void prettyDisplay(){
        preetyDisplay(root , 0);
    }

    private void preetyDisplay(Node node , int level){

        if (node == null){
            return ;
        }

        preetyDisplay(node.right , level + 1);

        if (level != 0){
            for (int i=0 ; i< level-1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.value);

        }else {
            System.out.println(node.value);
        }

        preetyDisplay(node.left, level + 1);

    }

    public List<List<Integer>> levelOrder (Node root){

        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSum = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSum; i++) {

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

    public List<Double> averageOfLevels (Node root){
        List<Double> result = new ArrayList<>() ;

        if (root == null){
            return result ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSum = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            double averageLevel = 0;
            for (int i = 0; i < levelSum; i++) {
                Node currentNode = queue.poll();
                averageLevel += currentNode.value ; 
                
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null){
                    queue.offer(currentNode.right);

                }                
            }
            averageLevel = averageLevel / levelSum ;
            result.add(averageLevel);
        }

        return result;
    }

    public Node findSuccessor (Node root , int key){

        if (root == null){
            return null ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node currentNode = queue.poll();

            if (currentNode.left != null ){
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null ){
                queue.offer(currentNode.right);
            }

            if (currentNode.value == key ){
                break ;
            }
            

        }
        return queue.peek();

    }

    
}
