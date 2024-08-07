import java.util.*;

public class ShortestPathInDirectedAcyclicG {
    static class Pair{
        int data;
        int weight;
        Pair(int data, int weight){
            this.data = data;
            this.weight = weight;
        }
    }
    public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0; i<N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        int[] visited = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<N; i++){
            if(visited[i] != 1){
                topo(adj, visited, st, i);
            }
        }

        int[] distance = new int[N];
        for(int i =0;i<N; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;

        while(!st.isEmpty()){
            int node = st.pop();
            if(distance[node] != Integer.MAX_VALUE){
                for(Pair p : adj.get(node)){
                    if(distance[p.data]> distance[node]+p.weight){
                        distance[p.data]= distance[node]+p.weight;
                    }
                }
            }
            
        }

        for(int i=0;i< N; i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] =-1;
            }
        }

        return distance;

	}

    public static void topo(ArrayList<ArrayList<Pair>> adj, int[] visited, Stack<Integer> st, int s){
        visited[s] =1;
        for(Pair a: adj.get(s)){
            if(visited[a.data] != 1){
                topo(adj, visited, st, a.data);
            }
        }
        st.push(s);
    }
}
