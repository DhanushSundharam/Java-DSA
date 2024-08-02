import java.util.ArrayList;
import java.util.HashSet;

public class NumberofDistinctIsland {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,0,1,1},
                        {0,0,0,1,0}
    };
    System.out.println(DistinctIsland(grid));
    }
    public static void dfs (int row , int col , int[][] vis , int[][] grid , int[] delrow ,int[] delcol ,ArrayList<String> vec , int row0 , int col0){

        vec.add(toString(row - row0 , col - col0));
        
        
        vis[row][col] = 0 ;
        int n = grid.length ;
        int m = grid[0].length ;

        for (int i = 0; i < 4; i++) {

            int rwo = row + delrow[i];
            int clo = col + delcol[i];

            if (rwo >= 0 && rwo < n && clo >= 0 && clo < m && grid[rwo][clo] == 1 && grid[rwo][clo] == 1){
                dfs(rwo, clo, vis, grid, delrow, delcol, vec, row0, col0);
            }
            
        }

        

    }


    private static String toString(int i, int j) {
        return Integer.toString(i) + " " + Integer.toString(j);
    }


    public static int DistinctIsland (int[][] grid){
        int n = grid.length ;
        int m = grid[0].length ;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        HashSet<ArrayList<String>> Sect = new HashSet<>() ;

        int[][] vis = grid ;

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && vis[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>() ;
                    dfs (i , j , vis , grid , delrow , delcol , vec,i,j) ;
                    Sect.add(vec) ;

                }

               

                
            }
            
        }
        return Sect.size() ;
    }
    
}
