import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        ArrayList<Integer> dfs  = new ArrayList<>();
        dfsg(0, adj, dfs, visited);


        return dfs;
    }

    public static void dfsg(int a, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, int[] visited){
        visited[a]=1;
        dfs.add(a);
        for(int ele : adj.get(a)){
            if(visited[ele] != 1){
                dfsg(ele, adj, dfs, visited);
            }
        }
    }
}
