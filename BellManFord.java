import java.util.ArrayList;

public class BellManFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] diatance = new int[V];
        for (int i = 0; i < V; i++) {
            diatance[i] = (int) 1e8;
        }
        diatance[S] = 0;

        for (int i = 0; i < V-1; i++) {

            for (ArrayList<Integer> a : edges) {
                int u = a.get(0);
                int v = a.get(1);
                int wt = a.get(2);
                if (diatance[u] != (int) 1e8) {
                    if (diatance[u] + wt < diatance[v]) {
                        diatance[v] = diatance[u] + wt;
                    }
                }
            }

        }

        for (ArrayList<Integer> a : edges) {
            int u = a.get(0);
            int v = a.get(1);
            int wt = a.get(2);
            if (diatance[u] != (int) 1e8) {
                if (diatance[u] + wt < diatance[v]) {
                    int[] temp = new int[1];
                    temp[0] =-1;
                    return temp;
                }
            }
        }

        return diatance;


    }
}
