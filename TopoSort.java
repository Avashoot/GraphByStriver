import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopoSort {

    //DFS
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] vis = new int[V];
        int[] ans = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(vis[i] != 1){
                topo(i,adj, vis, st);
            }
        }
        
        for(int i =0; i< V; i++){
            ans[i] = st.pop();
        }
        
        return ans;
    }
    
    private static void topo(int s, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st){
        vis[s] =1;
        for(int a: adj.get(s)){
            if(vis[a] != 1){
                topo(a, adj, vis,st);
            }
        }
        st.push(s);
    }

    //BFS kahn's algorithms

    static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree = new int[V];

        for(ArrayList<Integer> arr : adj){
            for (int a : arr) {
                indegree[a]++;
            }
        }

        Queue<Integer> q  = new LinkedList<>();
        for(int i=0; i< V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            ans.add(node);

            for(int a: adj.get(node)){
                indegree[a]--;
                if(indegree[a] == 0){
                    q.add(a);
                }
            }
        }

       int[] p = new int[V];
        for(int i =0; i< V; i++){
            p[i] = ans.get(i);
        }
        
        return p;
    }
}
