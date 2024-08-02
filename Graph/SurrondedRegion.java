class SurroundedRegion {
    public static void main(String[] args) {
        char[][] grid = {{'X', 'X', 'X', 'X'},
                         {'X', 'O', 'X', 'X'},
                         {'X', 'O', 'O', 'X'},
                         {'X', 'O', 'X', 'X'},
                         {'X', 'X', 'O', 'O'}};

        char[][] result = ReplaceOX(5, 4, grid);
        for (char[] row : result) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int row, int col, int[][] vis, char[][] mat, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < 4; i++) { // Changed the loop condition
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && mat[nRow][nCol] == 'O' && vis[nRow][nCol] == 0) { // Changed '0' to 'O'
                dfs(nRow, nCol, vis, mat, delRow, delCol);
            }
        }
    }

    public static char[][] ReplaceOX(int n, int m, char[][] mat) {
        int[][] vis = new int[n][m];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // Traverse first row
        for (int i = 0; i < m; i++) {
            if (mat[0][i] == 'O' && vis[0][i] == 0) {
                dfs(0, i, vis, mat, delRow, delCol);
            }
        }

        // Traverse last row
        for (int j = 0; j < m; j++) {
            if (mat[n - 1][j] == 'O' && vis[n - 1][j] == 0) {
                dfs(n - 1, j, vis, mat, delRow, delCol);
            }
        }

        // Traverse first column
        for (int k = 0; k < n; k++) {
            if (mat[k][0] == 'O' && vis[k][0] == 0) {
                dfs(k, 0, vis, mat, delRow, delCol);
            }
        }

        // Traverse last column
        for (int k = 0; k < n; k++) {
            if (mat[k][m - 1] == 'O' && vis[k][m - 1] == 0) { // Changed vis[k][0] to vis[k][m - 1]
                dfs(k, m - 1, vis, mat, delRow, delCol);
            }
        }

        // Replace all 'O's that are not visited with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }
}

