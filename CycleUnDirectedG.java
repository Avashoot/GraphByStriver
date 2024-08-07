import java.util.*;
class Pair{
    int curr;
    int prev;
    Pair(int curr, int prev){
        this.curr = curr;
        this.prev = prev;
    }
}
public class CycleUnDirectedG {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for(int i=0; i<V; i++){
            if(visited[i] != 1){
                if(detect(i, adj, visited))return true;
            }
        }
        return false;
        

    }

    boolean detect(int s, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[s] =1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s, -1));
        while(! q.isEmpty()){
            Pair p = q.remove();
            int curr = p.curr;
            int prev = p.prev;
            for(int adjecentNode : adj.get(curr)){
                if(visited[adjecentNode] != 1){
                    visited[adjecentNode] =1;
                    q.add(new Pair(adjecentNode, curr));
                }else{
                    if(prev != adjecentNode){
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
