

public class DFS {
    private static class Node {
        int value ;
        Node left ;
        Node right ;

        public Node (int value){
            this.value = value ;
        }
    }
    
    public void Flatten (Node root){

        Node current = root ;

        while (current != null){
            if (current.left != null){
                Node temp = current.left ;
                while (temp.right != null){
                    temp = temp.right ;
                }

                temp.right = current.right ;
                current.right = current.left ;
                current.left = null ;
            }

            current = current.right ;
        }

        
        

    }
    
    public boolean isValidBST (Node root){
        return helper (root , null ,null);
    }

    private boolean helper (Node node , Integer low , Integer high){
        if (node == null){
            return true ;
        }
        if (low != null && node.value <= low){
            return false ;

        }

        if (node.value >= high){
            return false ;

        }

        boolean leftTree = helper(node.left , low ,node.value);
        boolean rightTree =  helper(node.right , node.value , high);

        return leftTree && rightTree ;
    }
    
    public Node lowestCommonAncestor (Node root , Node p , Node q ){
        if (root == null){
            return null ;
        }

        if (root == p || root == q){
            return root ;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root ;
        }
         
        
        return left == null ? right :left ;
        
        
    }
    
    int count = 0;
    public Node kthSmallest(Node root , int k){
        if (root == null){
            return null ;
        }
        Node left = kthSmallest(root.left , k);
        if ( left != null) {
            return left ;
        }
        count ++ ;
        if (count == k){
            return root ;
        }

        return kthSmallest(root.right, k);


    }


}
