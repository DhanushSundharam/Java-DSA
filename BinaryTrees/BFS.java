
import java.util.ArrayList;
import java.util.Currency;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    @SuppressWarnings("unused")
    private class Node {
        Node left ;
        Node right ;
        Node next ;
        private int value ;

        public Node(int value){
            this.value = value ;

        }

        public int getValue (){
            return value ;
        }
    }
    
    public List<List<Integer>> LevelOrder (Node root){

        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return  result;
        }

        Queue<Node> queue = new LinkedList<>();

        while(!queue.isEmpty()){
            int levelSize = queue.size() ;
            List<Integer> currentresult = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentLevel = queue.poll();
                currentresult.add(currentLevel.value);

                if (currentLevel.left != null){
                    queue.add(currentLevel.left);
                }

                if (currentLevel.right != null){
                    queue.add(currentLevel.right);
                }
                
                
            }


            result.add(currentresult);


        }

        return result ;

    }

    public List<Double> AverageLevelOrder (Node root){
        List<Double> result = new ArrayList<>();

        if (root == null){
            return result ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> CurrentNode = new ArrayList<>() ;
            double average = 0 ;

            for (int i = 0; i < levelSize; i++) {
                Node pullfirstout = queue.poll();
                average += pullfirstout.value ;

                if (pullfirstout.left != null){
                    queue.add(pullfirstout.left);
                }

                if (pullfirstout.right != null){
                    queue.add(pullfirstout.right);
                }
            

                
            }

            double Avg = average / levelSize ;

            result.add(Avg);

        }
        return result ;
    }
    
    public int findNextNodeValue(Node root , int value){
        if (root == null){
            return (Integer) null;
        }

        Queue<Node> queue = new LinkedList<>();

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();

            if (currentNode.left != null){
                queue.add(currentNode.left);
            }

            if (currentNode.right != null){
                queue.add(currentNode.right);
            }

            if (currentNode.value == value){
                break ;
            }
        }

        return queue.poll().value;
    }
 
    public List<List<Integer>> zigzagLevelOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result ;
        }

        boolean reverse = false ;

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size() ;

           List<Integer> CurrentNode = new ArrayList<>();

           for (int i = 0; i < levelSize; i++) {
            if (!reverse){
                Node firsteleout = queue.pollFirst();
                CurrentNode.add(firsteleout.value);

                if (firsteleout.left != null){
                    queue.addLast(firsteleout.left);
                }

                if (firsteleout.right != null){
                    queue.addLast(firsteleout.right);
                }
                
                
            }else {

                Node lasteleOut = queue.pollLast();
                CurrentNode.add(lasteleOut.value);

                if (lasteleOut.right != null){
                    queue.addLast(lasteleOut.right);
                }

                if (lasteleOut.left != null){
                    queue.addLast(lasteleOut.left);
                }

            }

            
            
           }
           reverse = !reverse ;
           result.add(CurrentNode);

            
        }
        return result ;
    }
   
    public List<List<Integer>> LeverOrderBottom(Node root){

        List<List<Integer>> result = new ArrayList<>() ;

        if (root == null){
            return result ;
        }

        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root);

        while (!queue.isEmpty()){
            int LevelSize = queue.size();
            List<Integer> currentNode = new ArrayList<>() ;

            for (int i = 0; i < LevelSize; i++) {
                Node Firsteleout = queue.poll();
                currentNode.add(Firsteleout.value);

                if (Firsteleout.left != null){
                    queue.add(Firsteleout.left);

                }
                if (Firsteleout.right != null){
                    queue.add(Firsteleout.right);

                }
                
            }
            result.add(0,currentNode);
        }

        return result ;
        

    }

    public Node connect (Node root){
        if (root == null){
            return null ;
        }

        Node leftMost = root ;

        while (leftMost.left != null){
            Node current = leftMost ;
            while (current != null){
                current.left.next = current.right ;
                if (current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left ;



        }
        return root ;
    }
    
    public Node PopulationNext (Node root){
        if (root == null){
            return root ;

        }

        Node leftMost = root ;

        while (leftMost.left != null){
            Node Current = leftMost ;
            while (Current != null){

                Current.left.next = Current.right;
                if (Current.next != null){
                    Current.right.next = Current.next.left ; 
                }
                Current = Current.next ;
            }
            leftMost = leftMost.next ;

        }

        return root ;
    }

    public List<Integer> RightSide (Node root){
        List<Integer> result = new ArrayList<>() ;

        if (root == null){
            return result ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
           

            for (int i = 0; i < levelSize; i++) {
                Node firstNode = queue.poll();
                
                if (i == levelSize - 1){
                    result.add(i);
                }

                if (firstNode.left != null){
                    queue.add(firstNode.left);
                }

                if (firstNode.right != null){
                    queue.add(firstNode.right);
                }
                

            }

          
            
        }
        return result ;
    }

    public boolean isSymmetric (Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            Node left = queue.poll() ;
            Node right = queue.poll() ;

            if  (left == null && right == null){
                continue ;
            }

            if (left == null || right == null){
                return false ;
            }

            if (left.value != right.value){
                return false ;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true ;


    }
    
    
}
