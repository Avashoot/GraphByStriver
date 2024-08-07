import java.util.*;
public class ShortestPathInUndirectedG {
    static class Pair{
        int first, d;
        Pair(int first, int d){
            this.first = first;
            this.d = d;
        }
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int[] distence = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n; i++){
            distence[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        Queue<Pair> q = new LinkedList<>();
        distence[src] =0;
        q.add(new Pair(0, 0));

        while(!q.isEmpty())
        {
            Pair p = q.remove();
            int node = p.first;
            int d = p.d;
            for(int a: adj.get(node)){
                if(distence[a]>d+1){
                    distence[a] = d+1;
                    q.add(new Pair(a, d+1));
                }
            }


        }

        for(int i=0; i<n; i++){
            if(distence[i] == Integer.MAX_VALUE) distence[i] =-1;
        }

        return distence;
    }
}
