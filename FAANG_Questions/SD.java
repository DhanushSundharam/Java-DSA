import java.util.*;

public class SD {

    class Node {
        int data ;
        Node left ;
        Node right ;

        public Node (int data){
            this.data = data ;
        }
    }

    public List<String> serialize (Node node){
        List<String> list = new ArrayList<>() ;
        helper(node , list) ;
        return list ;
    }

    private void helper(Node node , List<String> list){
        if (node == null){
            list.add("null") ;
            return ;
        }

        list.add(String.valueOf(node.data));

        helper(node.left, list);
        helper(node.right, list);
    }

    public Node deserialize (List<String> list){
        Collections.reverse(list);
        Node node = helper2(list);
        return node ;
    }

    private Node helper2(List<String> list){
        String val = list.remove(list.size() - 1) ;

        if (val.charAt(0) == 'n'){
            return null ;
        }

        Node node = new Node (Integer.parseInt(val));

        node.left = helper2(list);
        node.right = helper2(list) ;

        return node ;

    }

    
    
}
