import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodesTopo {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj){
        List<List<Integer>> reverseadj = new ArrayList<>();
        for(int i=0; i<V; i++) reverseadj.add(new ArrayList<>());
        for(int i=0; i< V; i++){
            for(int j: adj.get(i))
            {
                reverseadj.get(j).add(i);
            }
        }

        int[] indegree = new int[V];
        for(List<Integer> arr : reverseadj){
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

        int[] check = new int[V];
        while (!q.isEmpty()) {
            int node = q.remove();
            check[node] =1;
            for(int a:reverseadj.get(node)){
                indegree[a]--;
                if(indegree[a] ==0){
                    q.add(a);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i] == 1)ans.add(i);
        }
        return ans;
    }
}
