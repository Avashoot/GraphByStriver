import java.util.*;


public class BipartiteGraphDFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] visited= new int[V];
        for(int i =0; i< V;i++) visited[i]=-1;


        for(int i =0; i< V; i++){
            if(visited[i] == -1){
                
                if(dfs(i,0, adj, visited)== false){
                    return false;
                }
            }
        }
        return true;
        
    }

    public static boolean dfs(int s,int col, ArrayList<ArrayList<Integer>>adj, int[] visited){
        visited[s] =col;

        for (int i : adj.get(s)) {
            if(visited[i] ==-1){
                int c = col==0 ?1:0;
                if(dfs(i,c, adj, visited)== false)return false;
            }else{
                if(visited[s] == visited[i]){
                    return false;
                }
            }
        }

        return true;
    }
}
