package RedandBlacktree;

public class RedBlackTree {
    private static final boolean RED = true ;
    private static final boolean BLACK = false ;

    class Node {
        int data ;
        Node parent ;
        Node left ;
        Node right ;
        boolean color ;

        Node (int data){
            this.data = data;
            this.color = RED ;
        }
    }

    private Node root ;

    public void insert (int data){
        Node node = new Node(data);
        root = insertRec(root , node);
        fixInsertViolations(node);
    }

    private Node insertRec(Node root , Node node){
        if (root == null){
            return node ;
        }
        if (node.data < root.data){
            root.left = insertRec(root.left , node);
            root.left.parent = root ;
        }
        else if (node.data > root.data){
            root.right = insertRec(root.right, node);
            root.right.parent = root ;
        }

        return root ;
    }
    
    private void fixInsertViolations(Node node){
        Node parent = null ;
        Node grandParent = null ;

        while (node != root && node.color != BLACK && node.parent.color == RED){

            parent = node.parent;
            grandParent = node.parent.parent ;

            // Case A : Check the Parent of Node is the left child of the Grandparent
            if (parent == grandParent.left){
                Node uncle = grandParent.right ;
                // case 1: The uncle of node is also red (only recoloring)
                if (uncle != null && uncle.color == RED){
                    grandParent.color = RED ;
                    parent.color = BLACK ;
                    uncle.color = BLACK ;
                    node = grandParent ;

                }

                else {
                    // case 2: node is the right child of its parent
                    // (Left-rotation needed)
                    if (node == parent.right){
                        //rotateLeft(parent);
                        node = parent ;
                        parent = node.parent ;
                    }

                    // case 3: node is the left child of its parent 
                    // (Right-rotation needed)
                    //rotateLeft(grandParent);
                    boolean tempColor = parent.color ;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor ;
                    node = parent ;
                }

            }
            else // (parent == grandParent.right) 
            {
                Node uncle = grandParent.left ;

                // Case 1: The Uncle of node is also red (only recoloring)
                if (uncle != null && uncle.color == RED){
                    grandParent.color = RED ;
                    parent.color = BLACK ;
                    uncle.color = BLACK ;
                    node = grandParent ;
                }
                else {
                    // case 2: node is the left child of its Parent
                    // (Right-Rotation needed)
                    if (node == parent.left){
                        //rotateRight(parent);
                        node = parent ;
                        parent = node.parent ;

                    }

                    // case 3: node is the right child of its parent 
                    // (Left-Rotation needed)
                    //rotateLeft(grandParent);
                    boolean tempColor = parent.color ;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor ;
                    node = parent ;
                }

            }

        }

        root.color = BLACK ;
    }
}
