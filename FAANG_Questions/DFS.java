public class DFS {

    private class Node  {
        int value ;
        Node left ;
        Node right ;

        public Node(int value){
            this.value = value ;
        }
    }

    public Node invertTree(Node root){
        if (root == null){
            return null ;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right ;
        root.right = left ;

        return root ;

    }

    public int maxDepth (Node root){
        if (root == null){
            return 0 ;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right) + 1 ;

        return depth ;
    }

    public void flatten (Node root){
        if (root == null){
            return  ;
        }

        Node current = root ;
        while (current != null) {
            if (current.left != null){
                Node temp = current.left ;
                while (temp.right != null) {
                    temp = temp.right ;
                    
                }

                temp.right = current.right ;
                current.right = current.left ;
                current.left = null ;
            }
            current = current.right ;
            
        }


    }

    public boolean isvalidBST (Node root){
        return helper(root , null , null);
    }

    private boolean helper(Node node , Integer low , Integer high){
        if (node == null){
            return true ;
        }
        if (low != null && node.value <= low){
            return false ;
        }

        if (high!= null && node.value >= high){
            return false ;
        }

        boolean leftTree = helper(node.left, low, node.value);
        boolean rightTree = helper(node.right, node.value, high);

        return leftTree && rightTree ;
    }
    
}
