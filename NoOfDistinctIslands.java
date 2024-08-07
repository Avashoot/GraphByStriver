import java.util.*;
// import java.util.stream.Gatherer.Integrator;

public class NoOfDistinctIslands {
    static class Pair{
        int r,c;
        Pair(int r, int c){
            this.r = r;
            this.c= c;
        }
    }
    
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n= grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Set<ArrayList<String>> ht = new HashSet<ArrayList<String>>();

        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 1 && visited[i][j] !=1){
                    ArrayList<String> ar = new ArrayList<>();
                    dfs(i, j, grid, visited, n, m, ar, i,j);
                    ht.add(ar);
                }
            }
        }

        return ht.size();
    }
    static String str(int r, int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    public static void dfs(int r, int c, int[][] grid, int[][] visited, int n, int m, ArrayList<String> hs, int br, int bc){
        
        visited[r][c] = 1;
        hs.add(str(r -br, c-bc));

        int[][] directions= {{0,-1},{0,1},{1,0},{-1,0}};

        for (int[] is : directions) {
            int nc = c+ is[1];
            int nr = r+ is[0];

            if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc] != 1 && grid[nr][nc]==1){
                
                dfs(nr, nc, grid, visited, n, m, hs, br, bc);
            }
        }


    }
}
