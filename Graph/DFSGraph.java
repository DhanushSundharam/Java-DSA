import java.util.*;
public class DFSGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjancency = new ArrayList<>() ;

        
        for (int i = 0; i < 10; i++) {

            adjancency.add(new ArrayList<>());

            
        }

        adjancency.get(1).add(2);
        adjancency.get(1).add(3);
        adjancency.get(2).add(1);
        adjancency.get(2).add(3);
        adjancency.get(2).add(4);
        adjancency.get(3).add(2);
        adjancency.get(4).add(2);
        adjancency.get(4).add(5);
        adjancency.get(5).add(4);
        adjancency.get(5).add(8);
        adjancency.get(6).add(1);
        adjancency.get(6).add(7);
        adjancency.get(6).add(9);
        adjancency.get(7).add(6);
        adjancency.get(7).add(8);
        adjancency.get(8).add(5);
        adjancency.get(8).add(7);
        adjancency.get(9).add(6);


       System.out.println(dfsofGraph(9,adjancency));

        
        
    }

    public static void dfs(int node , boolean[] vis , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ls){
        vis[node] = true ;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if (vis[it] == false){
                dfs(it, vis, adj, ls);
            }
            
        }
    }

    public static ArrayList<Integer> dfsofGraph(int v , ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v+1];
        vis[1] = true ;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(1,vis,adj,ls);
        return ls ;
    }
    
}
