
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeQuestions {

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

    public List<List<Integer>> zigzagLevelOrder (Node root){
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result ;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false ;

        while (!queue.isEmpty()){
            int levelSize = queue.size() ;
            List<Integer> currentLevel = new ArrayList<>(levelSize) ;
            for (int i = 0; i < levelSize; i++) {

                if (!reverse){
                    Node currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.value);

                    if (currentNode.left != null){
                        queue.addLast(currentNode.left);
                    }

                    if (currentNode.right != null){
                        queue.addLast(currentNode.right);
                    }
                

                }

                else {
                    Node currentNode = queue.pollLast();
                    currentLevel.add(currentNode.value);

                    if (currentNode.right != null){
                        queue.addFirst(currentNode.right);
                    }

                    if (currentNode.left != null){
                        queue.addFirst(currentNode.left);
                    }
                

                }

                

                
            }
            reverse = !reverse ;
            result.add(currentLevel);

        }
        return result ;
        
    }
    
}
