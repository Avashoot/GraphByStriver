import java.util.ArrayList;
import java.util.List;

public class EventualSafeNode {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        int[] check = new int[V];

        for(int i =0; i< V; i++){
            if(vis[i] !=1){
                checkDFS(vis, pathvis, adj, i, check);
            }
        }

        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(check[i] ==1){
                arr.add(i);
            }
        }
        return arr;
    }

    private static boolean checkDFS(int[] vis, int[] pathvis, List<List<Integer>> adj, int s, int[] check){
        vis[s] =1;
        pathvis[s] =1;
        check[s] =0;

        for(int a : adj.get(s)){
            if(vis[a] !=1){
                if (checkDFS(vis, pathvis, adj, a, check)== true) {
                    return true;
                }
            }else{
                if(pathvis[a] ==1){
                    return true;
                }
            }
        }
        pathvis[s] =0;
        check[s] =1;
        return false;
    }
}
