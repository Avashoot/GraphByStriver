import java.util.*;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] visited= new int[V];
        for(int i =0; i< V;i++) visited[i]=-1;


        for(int i =0; i< V; i++){
            if(visited[i] == -1){
                if(bfs(i, V, adj, visited)== false){
                    return false;
                }
            }
        }
        return true;
        
    }

    public static boolean bfs(int s, int V, ArrayList<ArrayList<Integer>>adj, int[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 0;

        while (!q.isEmpty()) {
            int a = q.remove();
            for(int is : adj.get(a)){
                if(visited[is] == -1){
                   visited[is] =(visited[a]== 0)? 1:0;
                   q.add(is);
                }else{
                    if(visited[a] == visited[is]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
