import java.util.*;

public class Bridge {
    
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[v];
        int[] tin = new int[v];
        int[] low = new int[v];
        int[] timer = new int[1];
        timer[0] =1;
        ArrayList<ArrayList<Integer>> bridees = new ArrayList<>();

        dfs(0, -1, visited, tin, low, adj, bridees, timer);

        Collections.sort(bridees, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return Integer.compare(a.get(0), b.get(0));
            }
        });

        return bridees;
    }

    private static void dfs(int src,int parent, int[] visited, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> bridges, int[] timer) {
        visited[src] =1;
        tin[src] = low[src] =timer[0];
        timer[0]++;
        for(int a: adj.get(src)){
            if(a == parent) continue;

            if(visited[a] ==0){
                dfs(a, src, visited, tin, low, adj, bridges, timer);
                low[src] = Math.min(low[src], low[a]);
                if(low[a] > tin[src]){
                    ArrayList<Integer> in = new ArrayList<>();
                    in.add(Math.min(a, src));
                    in.add(Math.max(a, src));
                    bridges.add(in);

                }
            }else{
                low[src] = Math.min(low[src], low[a]);  
            }
        }


    }
}
