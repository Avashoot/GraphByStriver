import java.util.ArrayList;


public class CycleUnDictedGDFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for(int i=0; i<V; i++){
            if(visited[i] != 1){
                if(dfs(i,-1, adj, visited))return true;
            }
        }
        return false;
        

    }

    boolean dfs(int s,int p, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[s] =1;
        for(int it : adj.get(s)){
            if(visited[it] != 1){
                if(dfs(it, s, adj, visited))return true;
            }else if(it != p){
                return true;
            }
        }
        return false;

    }
}
