import java.util.*;

public class KhanAlgorithm {
    

    public static int[] topoSort (int v , ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : indegree) {
                indegree[it]++ ;
                
            }
            
        }

        Queue<Integer> q = new LinkedList<>() ;
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0 ){
                q.add(i);
            }
            
        }

        int[] topo = new int[v] ;
        int i = 0;

        while (!q.isEmpty()){
            int node = q.remove();
            topo[i] = node ;
            i++;


            for (int j : adj.get(node)) {
                indegree[j]-- ;
                if (indegree[j] == 0){

                    q.add(j);

                }
                
            }

        }

        return topo ;
    }
    
}
