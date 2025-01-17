public class SegmentTree {

    public static void main(String[] args) {
        //int[] arr = {3,8,6,7,-2,-8,4,9};
        //SegmentTree tree = new SegmentTree(arr);
    }

    private static class Node {
        int data ;
        int startInterval ;
        int endInterval ;
        Node left ;
        Node right ;


        public Node (int startInterval , int endInterval){
            this.startInterval = startInterval ;
            this.endInterval = endInterval ;
        }
    }

    Node root ;

    public SegmentTree(int[] arr){
        //create a tree using this array
        this.root = constructTree(arr , 0 , arr.length - 1);

    }

    private Node constructTree ( int[] arr  , int start , int end){
        if (start == end){
            //leaf node
            Node leaf = new Node (start , end);
            leaf.data = arr[start];
            return leaf ;
        }

        // create new node with index you are at
        Node node = new Node (start ,  end);

        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data ;
        return node ;
    }

    public void display(){
        display(root);
    }

    private void display(Node node){
        String str = "";

        if (node.left != null){
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";

        }else{
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + "+ ->";

        if (node.right != null){
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data + " => ";

        }else{
            str = str + "No right child";
        }

        System.out.println(str);
        if (node.left != null){
            display(node.left);
        }

        if (node.right != null){
            display(node.right);
        }
    }

    // query
    public int query (int qsi , int qei){
        return query(root , qsi , qei);
    }
 
    private int query (Node node , int qsi , int qei){
        if (node.startInterval >= qsi && node.endInterval <= qei){
            // node is completely lying inside query 
            return node.data ;
        }else if (node.startInterval > qei || node.endInterval < qsi){
            //completely outside
            return 0 ;
        }else{
            int left = query(node.left , qsi , qei ) ;
            int right = query(node.right , qsi ,qei) ;

            return left + right ;

        }
    }

    
}
