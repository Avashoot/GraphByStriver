import java.util.*;
public class CleapestFlightWithKStops {
    static class Trire{
        int stops, node, dist;
        Trire(int stops, int node, int dist){
            this.stops= stops;
            this.node= node;
            this.dist= dist;
        }
    }

    static class Pair{
        int node, dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist= dist;
        }
    }
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr: flights){
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }

        int[] distance = new int[n];
        for(int i=0; i<n; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src]=0;
        Queue<Trire> q = new LinkedList<>();
        q.add(new Trire(0, src, 0));

        while(!q.isEmpty()){
            Trire t =q.remove();
            int stop = t.stops;
            int node = t.node;
            int dist = t.dist;
            for(Pair p: adj.get(node)){
                int d = dist + p.dist;
                if(stop > k) continue;
                if(stop <= k && distance[p.node] > d){
                    distance[p.node] = d;
                    q.add(new Trire(stop+1, p.node, d));
                }
            }
        }

        if(distance[dst] == Integer.MAX_VALUE)return -1;
        return distance[dst];
    }
}
