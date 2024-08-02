import java.util.ArrayList;
import java.util.LinkedList;
import java.util.* ;

class BFSGraph {
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


       System.out.println(bfsofgraph(10,adjancency));

        
    }

    public static ArrayList<Integer> bfsofgraph (int v , ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>() ;
        boolean vis[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>() ;

        q.add(1) ;
        vis[1] = true ;

        while (!q.isEmpty()){
            Integer node = q.poll() ;
            bfs.add(node) ;



            for (Integer it : adj.get(node)){
                if (vis[it] == false){
                    vis[it] = true ;
                    q.add(it);
                }
            }
        }

        return bfs ;
    }
}