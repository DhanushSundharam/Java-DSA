public class CyclicDetectionDir {
    private static void dfsCheck (int i , boolean[] vis , boolean[] path , int[][] adj){
        vis[i] = true ; 
        path[i] = true ;

        for (int j : adj[i]) {

            if (!vis[j]){
                dfsCheck(j, vis, path, adj);
            }
            
        }
    }

    public static void isCyclic(int v , int[][] adj) {
        boolean[] vis = new boolean[v+1];
        boolean[] path = new boolean[v+1];

        for (int i = 0; i < v+1; i++) {

            dfsCheck (i , vis , path , adj);
            
        }
    }
    
}
