public class NoOfEnclaves {
    int numberOfEnclaves(int[][] grid) {
        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i =0;i< n; i++){
            for(int j =0; j<m; j++){
                if(i==0 || j==0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        dfs(i, j, grid, visited, n, m);
                    }
                }
            }
        }
        int count =0;
        for(int i=0; i< n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    count++;
                } 
            }
        }
        return count;
    }

    public static void dfs(int r, int c, int[][] grid, int[][] visited, int n, int m){
        
        visited[r][c] = 1;

        int[][] directions= {{0,-1},{0,1},{1,0},{-1,0}};

        for (int[] is : directions) {
            int nc = c+ is[1];
            int nr = r+ is[0];

            if(nr>-0 && nr<n && nc>=0 && nc<m && visited[nr][nc] != 1 && grid[nr][nc]==1){
                dfs(nr, nc, grid, visited, n, m);
            }
        }


    }
}
