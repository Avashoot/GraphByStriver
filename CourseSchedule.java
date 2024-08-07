import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n; i++) adj.add(new ArrayList<>());
        
        for(ArrayList<Integer> a :prerequisites){
            adj.get(a.get(1)).add(a.get(0));
        }
        
        
        int[] indegree = new int[n];
        for(ArrayList<Integer> arr: adj){
            for(int a: arr){
                indegree[a]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< n; i++){
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
        if(ans.size() == n){
            int[] p = new int[n];
            for(int i =0; i< n; i++){
                p[i] = ans.get(i);
            }
        
            return p;
        }
        int[] p={};
        return p;
        
    }
}
