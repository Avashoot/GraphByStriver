import java.util.*;

public class MinMulReachEnd {
    static class Pair{
        int node, step;
        Pair(int step, int node){
            this.node = node;
            this.step = step;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        int[] distance = new int[100000];
        int mod = 100000;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        distance[start] =0;
        while (! q.isEmpty()) {
            Pair p = q.remove();
            int node = p.node;
            int step = p.step;

            for(int a: arr){
                int mul = (node*a)%mod;
                int s=step+1;
                if(mul == end) return s;
                if(distance[mul] == 0 && mul != start){
                    distance[mul] =s;
                    q.add(new Pair(s, mul));
                }

            }
        }

        return 0;


    }
}
