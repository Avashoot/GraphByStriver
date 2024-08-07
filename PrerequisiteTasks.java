import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrerequisiteTasks {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i< N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i< P; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] indegree = new int[N];

        for (ArrayList<Integer> arr : adj) {
            for(int a : arr){
                indegree[a]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< N; i++){
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

        if(ans.size()== N)return true;
        return false;
    }

}
