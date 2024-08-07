import java.util.*;

public class Prims {
    static class Tuple{
        int wt, curr, parent;
        Tuple(int wt, int curr, int parent){
            this.wt = wt;
            this.curr = curr;
            this.parent = parent;
        }
    }

    static class Pair{
        int wt, node;
        Pair(int wt, int node){
            this.node=node;
            this.wt = wt;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p->p.wt));
        int[] vis = new int[V];

        pq.add(new Pair(0, 0));

        int sum =0;
        while(! pq.isEmpty()){
            Pair p = pq.remove();
            int wt =p.wt;
            int node = p.node;
            if(vis[node] ==1) continue;
            vis[node] =1;
            sum += wt;
            
            for(int[] q: adj.get(node)){
                int adjnode = q[0];
                int weight = q[1];
                if(vis[adjnode]==0){
                    pq.add(new Pair(weight, adjnode));
                }
            }

        }
        return sum;
        
    }

    public static void main(String[] args) {
        // Example usage
        int V = 5; // Number of vertices
        int E = 7; // Number of edges
        List<List<int[]>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < E; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Example edges: (source, destination, weight)
        adj.get(0).add(new int[]{1, 2, 3});
        adj.get(1).add(new int[]{0, 2, 3});
        adj.get(0).add(new int[]{2, 3, 5});
        adj.get(2).add(new int[]{0, 3, 5});
        adj.get(1).add(new int[]{2, 4, 7});
        adj.get(2).add(new int[]{1, 4, 7});
        adj.get(1).add(new int[]{3, 6, 6});
        adj.get(3).add(new int[]{1, 6, 6});
        adj.get(2).add(new int[]{4, 2, 8});
        adj.get(4).add(new int[]{2, 8, 2});
        
        // Call the spanningTree method
        System.out.println(spanningTree(V, E, adj)); // Output the weight of the MST
    }
}
