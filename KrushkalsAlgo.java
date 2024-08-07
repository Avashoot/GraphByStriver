import java.util.*;
// import java.io.*;

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    // List<Integer> size = new ArrayList<>();

    //constructor
    public DisjointSet(int n){
        for(int i =0; i<= n; i++){
            rank.add(0);
            parent.add(i);
            // size.add(1);
        }
    }

    //finding the ultimate parent
    public int findUPar(int node){
        if(node != parent.get(node)){
            parent.set(node, findUPar(parent.get(node)));
        }
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;

        else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }else if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }


    // public void unionBySize(int u, int v){
    //     int ulp_u = findUPar(u);
    //     int ulp_v = findUPar(v);
    //     if(ulp_u == ulp_v) return;
    //     else if(size.get(ulp_u) < size.get(ulp_v)){
    //         parent.set(ulp_u, ulp_v);
    //         size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
    //     }else {
    //         parent.set(ulp_v, ulp_u);
    //         size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
    //     }


    // }


}

public class KrushkalsAlgo {
    static class Touple{
        int wt, src, dest;
        Touple(int wt, int src, int dest){
            this.wt = wt;
            this.src= src;
            this.dest= dest;
        }
    
    };
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Touple> edges = new ArrayList<>();
        DisjointSet ds = new DisjointSet(V);
        for(int i=0; i<V; i++){
            for(int[] arr: adj.get(i)){
                int adjNode = arr[0];
                int weight = arr[1];
                edges.add(new Touple(weight, i, adjNode));
            }
        }

        Collections.sort(edges, new Comparator<Touple>() {
            public int compare(Touple t1, Touple t2){
                return Integer.compare(t1.wt, t2.wt);
            }
        });

        int mstWt =0;

        for(Touple t : edges){
            int wt = t.wt;
            int src = t.src;
            int dest = t.dest;

            if(ds.findUPar(src) != ds.findUPar(dest)){
                mstWt += wt;
                ds.unionByRank(src, dest);
            }
        }

        return mstWt;
    }
}
