import java.util.*;

public class KasarajuAlgo {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int[] visited = new int[V];
        Arrays.fill(visited, 0);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++)
        {
            if(visited[i] ==0){
                dfs(adj, visited, i, st);
            }
        }

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<V; i++){
            visited[i] =0;
            for(int a: adj.get(i)){
                arr.get(a).add(i);
            }
        }

        int scc =0;
        while(!st.isEmpty()){
            int src = st.pop();
            if(visited[src] ==0){
                scc++;
                dfs2(arr, visited, src);
                
            }
        }
        return scc;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int src, Stack<Integer> st){
        visited[src] =1;
        for(int a : adj.get(src)){
            if(visited[a] != 1){
                dfs(adj, visited, a, st);
            }
        }
        st.push(src);

    }

    static void dfs2(ArrayList<ArrayList<Integer>> adj, int[] visited, int src){
        visited[src] =1;
        for(int a : adj.get(src)){
            if(visited[a] != 1){
                dfs2(adj, visited, a);
            }
        }
    }
}
