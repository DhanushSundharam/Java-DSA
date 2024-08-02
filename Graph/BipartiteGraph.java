import java.util.* ;
public class BipartiteGraph {
    private static boolean dfs (int node , int col , int color[] ,  ArrayList<ArrayList<Integer>> adj){
        color[node] = col ;
        for ( int it : adj.get(node)) {
            if (color[it] == -1){
                if (dfs(it, 1, color, adj)==false){
                    return false ;

                }
            }
            else if (color[it] == col){
                return false ;
            }
            
        }
        return true ;
    }

    public static boolean isBipartite (int v , ArrayList<ArrayList<Integer>> adj){

        int[] color = new int[v] ;
        for (int i = 0; i < v; i++) {
            color[i] = -1 ;
            
        }

        for (int i = 0; i < v; i++) {
            if (color[i] == -1){
                if (dfs(i,0,color , adj)== false) return false ;
            }
            
        }

        return true ;


    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
            
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        int v = 5 ;

        System.out.println(isBipartite(v,adj));
    }
}
