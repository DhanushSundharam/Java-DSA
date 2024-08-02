import java.util.*;

public class SDString {

    class Node {
        int data ;
        Node left ;
        Node right ;

        public Node (int data){
            this.data = data ;
        }
    }

    public String serialize (Node node){

        String str = "";
        helper(node , str);
        return str ;

    }

    private void helper (Node node ,String str ){
        if (node == null){
            str += "null,";
        }

        str += String.valueOf(node.data+",");

        helper(node.left, str);
        helper(node.right, str);


    }

    public Node deserialize (String str){
        String[] convertList = str.split(",");
        
        List<String> list = Arrays.asList(convertList);
        Collections.reverse(list);

        Node node  =  helper2(list);
        return node ;
        
      
    }

    private Node helper2(List<String> list){

        String last = list.remove(list.size() - 1);

        if (last.charAt(0) == 'n'){
            return null ;
        }

        Node node = new Node (Integer.parseInt(last));

        node.left = helper2(list);
        node.right = helper2(list);

        return node ;

    }

    public boolean pathSum(Node node , int targetSum){
        if (node == null){
            return false ;
        }
        if (node.data - targetSum == 0 && node.left == null && node.right == null ){
            return true ;
        }

        boolean left = pathSum(node.left, node.data - targetSum);
        boolean right = pathSum(node.right, node.data - targetSum);

        return left || right ;
    }

   

    
   

  public int sumNumbers(Node node){
    return helper(node, 0);
  }

  public int helper (Node node , int sum){
    if (node == null){
        return 0 ;
    }
     sum = sum * 10 + node.data ; 
     
     int left = helper(node.left , sum) ;
     int right = helper(node.right, sum);

     return left+right ;



  }

  int ans = Integer.MAX_VALUE ;

  public int maxPathSum (Node node){

    helper(node);
    return ans ;
  }

  private int helper(Node node){
    if (node == null){
        return 0 ;
    }
    int left = helper(node.left);
    int right = helper(node.right) ;

    left = Math.max(0,left);
    right = Math.max(0, right);

    int maximum = left + right + node.data ;
    ans = Math.max(ans, maximum);

    return Math.max(left,right) + node.data ;
  }

    
}
