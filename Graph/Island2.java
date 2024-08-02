import java.util.ArrayList;

public class Island2 {

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},
                        {0,1,1,0},
                        {0,0,1,0},
                        {0,0,0,0},
                        {1,1,0,1}
    };
    System.out.println(NumberIsland(grid));
    }

    public static void dfs (int row , int col , int[][]grid , int[][] vis){
        vis[row][col] = 1 ;

        for (int i = -1 ; i <= 1 ; i++) {
            for (int j = -1 ; j <= 1 ; j++) {

                int nrow = row + i ;
                int ncol = col + j ;

               if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 1 && vis[nrow][ncol]==0){
                dfs(nrow, ncol, grid, vis);
               }
                
            }
            
        }


        for (int i = 0; i < vis.length; i++) {
            
        }
    }

    public static int NumberIsland ( int[][] grid){

        

        int row  = grid.length ;
        int col = grid[0].length ;

        int[][] vis = new int[row][col] ;

        int count  = 0 ;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1 && vis[i][j]== 0){

                    count ++ ;

                    dfs(i , j , grid , vis);


                }
                
            }
            
        }
        return count ;

    }
    
}
