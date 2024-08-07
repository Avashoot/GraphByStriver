import java.util.*;

public class PrintShortestPath {
    static class Pair{
        int node;
        int distance;
        Pair(int distance,int node){
            this.node = node;
            this.distance = distance;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr: edges){
            adj.get(arr[0]).add(new Pair( arr[2],arr[1]));
            adj.get(arr[1]).add(new Pair( arr[2],arr[0]));
        }

        PriorityQueue<Pair> pq =new PriorityQueue<>(Comparator.comparingInt(p->p.distance));
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Pair(0, 1));
        dist[1] =0;


        while(! pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int distance = p.distance;

            for(Pair a : adj.get(node)){
                int d= distance + a.distance;
                if(d< dist[a.node]){
                    dist[a.node] = d;
                    parent[a.node] = node;
                    pq.add(new Pair(d, a.node));
                }
            }
        }

        if(dist[n] == Integer.MAX_VALUE){
            List <Integer> lt= new ArrayList<>();
            lt.add(-1);
            return lt;

        }
        List<Integer> l = new ArrayList<>();
        
        int i =n;
        l.add(n);
        while(parent[i] != i){
            l.add(parent[i]);
            i = parent[i];
        }
        l.add(dist[n]);
        Collections.reverse(l);
        
        
        return l;

    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int m = 6; // Number of edges

        int[][] edges = {
            {1, 2, 2},
            {2, 5, 5},
            {2, 3, 4},
            {1, 4, 1},
            {4, 3, 3},
            {3, 5, 1}
        };

        System.out.println(shortestPath(n, m, edges));
    }
}
