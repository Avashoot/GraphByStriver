import java.util.*;

public class DistanceNearHava1 {
    static class Pair{
        int row;
        int col;
        int d ;
        Pair(int row, int col, int d){
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j =0; j< m; j++){
                if(grid[i][j] ==1){
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 0;
                }
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;
            int d = p.d;

            for (int[] is : directions) {
                int nr = r+is[0];
                int nc= c+is[1];

                if(nr>= 0 && nr<n && nc>=0 && nc < m && grid[nr][nc] != 1 && grid[nr][nc] ==0) {
                    q.add(new Pair(nr, nc, d+1));
                    visited[nr][nc] = d+1;
                    grid[nr][nc] =1;
                }
            }
        }
        return visited;
    }
}
