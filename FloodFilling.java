public class FloodFilling {

    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int initialCol = image[sr][sc];
        int[][] copy = image;
        DFS(copy, newColor, sr, sc, initialCol);

        return copy;
    }

    public static void DFS(int[][] copy, int newColor, int sr, int sc, int initialCol){
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int n = copy.length;
        int m = copy[0].length;
        copy[sr][sc] = newColor;
        for(int[] a : directions){
            
                int nr = sr + a[0];
                int nc = sc + a[1];
                if(nr>= 0 && nr<n && nc>=0 && nc < m && copy[nr][nc] == initialCol && copy[nr][nc] != newColor){
                    DFS(copy, newColor, nr, nc, initialCol);
                }
            
        }
    }
}