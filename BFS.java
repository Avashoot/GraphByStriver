import java.util.*;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        q.add(0);
        arr.add(0);
        visited[0] =1;
        while(! q.isEmpty()){
            int a = q.remove();
            ArrayList<Integer> con = adj.get(a);
            for(int ele : con){
                if(visited[ele] != 1){
                    q.add(ele);
                    arr.add(ele);
                    visited[ele]= 1;
                }
            }
        }
        return arr;
        
    }
}
