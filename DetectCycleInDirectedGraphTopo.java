import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraphTopo {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[V];

        for (ArrayList<Integer> arr : adj) {
            for(int a : arr){
                indegree[a]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< V; i++){
            if(indegree[i] ==0) q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            ans.add(node);

            for(int a: adj.get(node)){
                indegree[a]--;
                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }

        if(ans.size()== V)return false;
        return true;
    }
}
