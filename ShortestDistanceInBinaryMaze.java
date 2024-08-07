import java.util.*;

public class ShortestDistanceInBinaryMaze {
    static class Trire{
        int d, r, c;
        Trire(int d, int r, int c){
            this.d =d;
            this.r =r;
            this.c =c;
        }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0] == destination[0] && source[1]== destination[1]) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for(int i =0; i< n; i++){
            for(int j = 0; j< m; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[source[0]][source[1]] = 0;
        Queue<Trire> q = new LinkedList<>();
        q.add(new Trire(0, source[0], source[1]));

        int[][] dist ={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };

        while(!q.isEmpty()){
            Trire t = q.remove();
            int r = t.r;
            int c = t.c;
            int d = t.d;
            for(int[] a: dist){
                int nr = r+a[0];
                int nc = c+a[1];
                if(nc>=0 && nc<m && nr>=0 && nr<n && grid[nr][nc]==1){
                    int td = d +1;
                    if(distance[nr][nc]> td){
                        distance[nr][nc] = td;
                        if(nr == destination[0] && nc == destination[1]) return td;
                        q.add(new Trire(td, nr, nc));
                    }
                    
                }
            }
        }
        return -1;
    }
}
