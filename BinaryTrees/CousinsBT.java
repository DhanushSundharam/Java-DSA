

public class CousinsBT {

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

    public boolean isCousins (Node root , int x , int y){
        Node xx = findNode(root , x);
        Node yy = findNode(root , y);

        return (
            (level(root,xx,0) == level(root, yy , 0) && (!isSibling(root,xx,yy)))
        );
    }

    private Node findNode(Node node , int x){
        if ( node == null){
            return null ;

        }
        if (node.value == x){
            return node ;
        }

        Node n = findNode(node.left, x);

        if (n!=null){
            return n ;
        }

        return findNode(node.right , x);
    }


    private boolean isSibling (Node node , Node x ,Node y){
        if (node == null){
            return  false ;
        }


        return (
            (node.left == x && node.right == y) ||  (node.left == y && node.right == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y)
            );

    }

    private int level (Node node , Node x , int lev){
        if (node == null){
            return 0 ;
        }

        if  (node == x){
            return lev ;
        }

        int l = level(node.left, x, lev + 1);
        if (l != 0){
            return l ;
        }
        return level (node.right , x ,lev + 1);
    }

    
}
