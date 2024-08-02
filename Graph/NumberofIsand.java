import java.util.*;
public class NumberofIsand {

    public static void dfs(int node , boolean[] vis , ArrayList<Integer> ans , ArrayList<ArrayList<Integer>> adj){
        vis[node] = true ;  
        ans.add(node) ; 

        for (Integer it : adj.get(node)) {

            if (!vis[it]){
                dfs(it, vis, ans, adj);
            }
            
        }
    }

    public static  ArrayList<Integer> Traversal (int v , ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v+1];
        ArrayList<Integer> ans = new ArrayList<>() ;
        

        dfs (1 , vis, ans,adj);
        return ans ;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;

        int v = 5 ;

        for (int i = 0; i < v+1; i++) {

            adj.add(new ArrayList<>()) ;
            
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(3);
        adj.get(5).add(3);

        System.out.println(Traversal(v, adj));
    }
    
}
