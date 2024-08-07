// import java.nio.channels.Pipe;
import java.util.*;

public class RottenOranges {

    static class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.time = time;
            this.col = col;
            this.row = row;
        }
    }
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = grid;
        Queue<Pair> q = new LinkedList<>();
        for(int i =0; i< n; i++)
        {
            for(int j =0; j< m ; j++){
                if(visited[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int[][] direction = {
            {-1, 0},
            {1,0},
            {0,-1},
            {0,1}
        };
        int tm =0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int r = p.row;
            int c= p.col;
            int t = p.time;
            tm = Math.max(tm,t);
            for (int[] is : direction) {
                int nr = r+is[0];
                int nc = c+is[1];

                if(0<=nr && nr<n && 0<=nc && nc<m && visited[nr][nc] != 2 && visited[nr][nc] == 1){
                    q.add(new Pair(nr, nc, t+1));
                    visited[nr][nc] =2;
                    tm = t;
                }
            }

        }
        for(int i =0; i< n; i++)
        {
            for(int j =0; j< m ; j++){
                if(visited[i][j] == 1){
                    return -1;
                }
            }
        }
        return tm;


    }
}
