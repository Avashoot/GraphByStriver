import java.util.*;

public class NoOfWaysToDestArive {
    static class Pair {
        int dist, node;
        Pair(int dist, int node){
            this.dist =dist;
            this.node =node;
        }
        
        
    }
    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] ways = new int[n];
        int[] distance = new int[n];
        int mod = (int)(1e9+7);

        for(int i=0; i< n; i++){
            adj.add(new ArrayList<>());
            ways[i] =0;
            distance[i] = Integer.MAX_VALUE;
        }
        for(List<Integer> l : roads){
            adj.get(l.get(0)).add(new Pair(l.get(2), l.get(1)));
            adj.get(l.get(1)).add(new Pair(l.get(2), l.get(0)));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p->p.dist));
        pq.add(new Pair(0, 0));
        distance[0] =0;
        ways[0] =1;

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int curr = p.node;
            int cd = p.dist;
            if(cd == 1000000000){
                cd =( p.dist)%1000000000 +1;
            }

            for(Pair ap : adj.get(curr)){
                int adjnode = ap.node;
                int d = ap.dist + cd;
                if(d<=distance[adjnode]){
                    if(d == distance[adjnode]){
                        ways[adjnode] = (ways[adjnode] + ways[curr])%mod;
                    }else{
                        distance[adjnode] = d;
                        ways[adjnode] =  ways[curr];
                        pq.add(new Pair(d, adjnode));
                    }
                    

                }
            }
        }
        return ways[n-1]%mod;

 
    }

    public static void main(String[] args) {

        int n = 6;
        List < List < Integer >> roads = new ArrayList < > () {
            {

                add(new ArrayList<Integer>(Arrays.asList(0,1, 1000000000)));
                add(new ArrayList<Integer>(Arrays.asList(0, 3, 1000000000)));
                add(new ArrayList<Integer>(Arrays.asList(1, 3, 1000000000)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, 1000000000)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, 1000000000)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, 1000000000)));
                add(new ArrayList<Integer>(Arrays.asList(4, 5, 1000000000)));
                add(new ArrayList<Integer>(Arrays.asList(2, 5, 1000000000)));
                // add(new ArrayList<Integer>(Arrays.asList(0, 4, 5)));
                // add(new ArrayList<Integer>(Arrays.asList(4, 6, 2)));

            }
        };
        
        int ans =countPaths(n, roads);

        System.out.print(ans);
        System.out.println();
    }
}
