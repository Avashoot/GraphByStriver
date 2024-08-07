public class SourrendedO {
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int[][] visited = new int[n][m];
        for(int i =0;i< n; i++){
            for(int j =0; j<m; j++){
                if(i==0 || j==0 || i == n-1 || j == m-1){
                    if(a[i][j] == 'O'){
                        dfs(i, j, a, visited, n, m);
                    }
                }
            }
        }
        char[][] b = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                if(visited[i][j] == 1){
                    b[i][j] = 'O';
                }else{
                    b[i][j] = 'X';
                }
            }
        }
        return b;
    }
    public static void dfs(int r,int c, char[][] a, int[][] visited, int n, int m){
        int[][] directions = {{-1,0},{1,0},{0, -1},{0,1}};
        visited[r][c] =1;
        for(int[] p : directions){
            int nr = r +p[0];
            int nc = c+ p[1];
            if(nr>=0 && nr < n && nc>=0 && nc<m && visited[nr][nc] != 1 && a[nr][nc] == 'O'){
                dfs(nr, nc, a, visited, n, m);
            }
        }
    }
}
