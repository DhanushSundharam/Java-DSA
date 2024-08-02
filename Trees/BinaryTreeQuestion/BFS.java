package BinaryTreeQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFS {

    class Node {
        int value ;
        Node left ;
        Node right;

        public Node(int value){
            this.value = value ;
        }

    }

    public List<List<Integer>> levelOrder (Node root){

        List<List<Integer>> result = new ArrayList<>() ;

        if (root == null){
            return result ;
        }

        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> Currentlevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node CurrentNode = queue.poll() ;
                Currentlevel.add(CurrentNode.value);

                if (CurrentNode.left != null){
                    queue.offer(CurrentNode.left);
                }
                if (CurrentNode.right != null){
                    queue.offer(CurrentNode.right);
                }
                
            }

            result.add(Currentlevel);
        }
        return result;
    }
    
    // Google Questions
    public List<Integer> leverlOrderAverage (Node root){

        List<Integer> result = new ArrayList<>() ;

        if (root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root);

        while  (!queue.isEmpty()){
            int levelSize = queue.size() ;
            int sum = 0 ;
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll() ;
               sum += currentNode.value ;

               if (currentNode.left != null){
                  queue.add(currentNode.left);
               }

               if (currentNode.right != null){
                queue.add(currentNode.right);
             }
                
            }

            int Average = sum / levelSize ;
            result.add(Average);

        }

        return result ;


    }

   

  


    }
    

