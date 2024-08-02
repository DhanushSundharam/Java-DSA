import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main{

    private class Node {
        int data  ;
        Node left ; 
        Node right ;
        Node next ;
        @SuppressWarnings("unused")
        public Node (int data){
            this.data = data ;
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
            int levelSize = queue.size() ;
            List<Integer> currentLevel = new ArrayList<>() ;

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll() ;
                currentLevel.add(currentNode.data);

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


    public List<Double> AverageLevel (Node root){
        List<Double> result = new ArrayList<>() ;

        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root) ;

        while (!queue.isEmpty()){
            int levelSize = queue.size() ;

            Double Sum = 0.0;

          
           for (int i = 0; i < levelSize; i++) {
            Node currNode = queue.poll() ;
            Sum = Sum +  currNode.data ;

            if (currNode.left != null){
                queue.offer(currNode.left);
            }

            if (currNode.right != null){
                queue.offer(currNode.right) ;
            }
         
            
           
            
           }

           Double Average = Sum / levelSize ;
           result.add(Average);

           
        }
        return result ;

    }

    public Node findSuccessor (Node root , int key){
        if (root == null){
            return null ;
        }

        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root) ;

        while(!queue.isEmpty()){
            Node CurrentNode = queue.poll() ;

            if (CurrentNode.left != null){
                queue.add(CurrentNode.left);
            }
            if (CurrentNode.right != null){
                queue.add(CurrentNode.right);

            }

            if (CurrentNode.data == key){
                break ;
            }
        }

        return queue.peek();
    }

    public List<List<Integer>> ZigZag (Node root){
        List<List<Integer>> result = new ArrayList<>() ;
        if (root == null){
            return result ;
        }

        Deque<Node> queue = new LinkedList<>() ;
        queue.offer(root) ;

        boolean isreversable = false ;
        
        while (!queue.isEmpty()){
            int levelSize = queue.size() ;
            List<Integer> currentLevel = new ArrayList<>() ;

            if (isreversable){
                for (int i = 0; i < levelSize ; i++) {
                    Node CurrentNode = queue.pollFirst() ;
                    currentLevel.add(CurrentNode.data);

                    if (CurrentNode.left != null){
                        queue.addLast(CurrentNode.left);
                    }
                    if (CurrentNode.right != null){
                        queue.addLast(CurrentNode.right);
                    }
                    
                }

            }
            else{

                for (int i = 0; i < levelSize ; i++) {
                    Node CurrentNode = queue.pollLast() ;
                    currentLevel.add(CurrentNode.data);

                    if (CurrentNode.left != null){
                        queue.addFirst(CurrentNode.left);
                    }
                    if (CurrentNode.right != null){
                        queue.addFirst(CurrentNode.right);
                    }
                    
                }

            }

            isreversable = !isreversable ;
            result.add(currentLevel);

            
        }

        return result ;
    }

    public List<List<Integer>> reverselevelOrder (Node root){
        List<List<Integer>> result = new ArrayList<>() ;

        if (root == null){
            return result ;
        }

        Queue<Node> queue  =  new LinkedList<>() ;
        queue.offer(root) ;

        while (!queue.isEmpty()){
            int levelSize = queue.size() ;
            List<Integer> currentLevel = new ArrayList<>() ;

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll() ;
                currentLevel.add(currentNode.data);

                if (currentNode.left != null){
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null){
                    queue.add(currentNode.right);
                }
                
            }

            result.add(0,currentLevel);
        }

        return result ;

    }

    public Node nextRightPointer(Node root ){
        if (root == null){
            return null ;
        }

        Node leftmost  = root ;

        while (leftmost.left != null){
            Node current = leftmost ;
          while(current != null){
            current.left.next = current.right;
            if(current.next != null){
                current.right.next = current.next.left ;
            }
            current = current.next ;

          }  
          leftmost = leftmost.left ;
           
        }

        return root ;
    }

    public List<Integer> binaryTreeRightSide(Node root){
        List<Integer> result = new ArrayList<>() ;
        if (root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root) ;

        while (!queue.isEmpty()){
            int levelSize = queue.size() ;


            for (int i = 1; i <= levelSize; i++) {
                Node CurrentNode = queue.poll() ;

                if (i == levelSize){
                    result.add(CurrentNode.data) ;
                }

                if (CurrentNode.left != null){
                    queue.add(CurrentNode.left);
                }

                if (CurrentNode.right != null){
                    queue.add(CurrentNode.right);
                }

               

                

                
            }
        }

        return result ;

    }

}