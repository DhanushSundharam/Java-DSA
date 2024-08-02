public class NumberofDIsland {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},
                        {1,0,1,0},
                        {0,1,1,1},
                        {0,0,0,0}
    };

    System.out.println(DisIsland(4, 4, grid));
    }

    public static void dfs (int row , int col , int[][] vis ,int[][] grid , int[] delrow , int[] delcol){
        vis[row][col] = 0 ;

        int nrow = grid.length ;
        int ncol = grid[0].length ;
        
        for (int i = 0; i < 4; i++) {
            int trow = row + delrow[i];
            int tcol = col + delcol[i] ;
            
            if ( trow >= 0 && trow < nrow && ncol >=0 && ncol < tcol && grid[trow][tcol] == 1 && vis[trow][tcol] == 1){
                dfs(trow, tcol, vis, grid, delrow, delcol);

            }
            
        }
    }

    public static int DisIsland (int n , int m , int[][] grid){
        int[][] vis = grid ;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1 && vis[0][i] == 1){
                dfs ( 0 , i , vis ,grid , delrow, delcol);

            }
            
        }

        for (int i = 0; i < m; i++) {
            if (grid[m-1][i] == 1 && vis[m-1][i] == 1){
                dfs ( m-1 , i , vis ,grid , delrow, delcol);

            }
            
        }


        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 1){
                dfs ( i,0  , vis ,grid , delrow, delcol);

            }
            
        }


        for (int i = 0; i < n; i++) {
            if (grid[i][n-1] == 1 && vis[i][n-1] == 1){
                dfs ( i , n-1 , vis ,grid , delrow, delcol);

            }
            
        }

        int count = 0 ;

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (vis[i][j] == 1){

                    count ++ ;

                }
                
            }
            
        }

        return count ;

    }
    
}
