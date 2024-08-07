import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasPriority {
    static class Pair{
        int dis;
        int nod;
        Pair(int dis, int nod){
            this.dis = dis;
            this.nod = nod;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq =new PriorityQueue<>(Comparator.comparingInt(p -> p.dis));
        int[] distance = new int[V];
        for(int i =0; i<V; i++) distance[i] = (int)1e9;
        pq.add(new Pair(0, S));
        distance[S] =0;

        while (pq.size() != 0) {
            Pair p = pq.remove();
            int dis = p.dis;
            int nod = p.nod;

            for(int i =0; i< adj.get(nod).size(); i++){
                int edgeWeight = adj.get(nod).get(i).get(1);
                int adjNode  = adj.get(nod).get(i).get(0);

                if(dis + edgeWeight < distance[adjNode]){
                    distance[adjNode] = dis+edgeWeight;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }

        return distance;


    }
}
