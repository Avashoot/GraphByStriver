import java.util.*;

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    //constructor
    public DisjointSet(int n){
        for(int i =0; i<= n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    //finding the ultimate parent
    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);

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


    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        else if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }


    }


}

public class MostStonesRemoved {

    int maxRemove(int[][] stones, int n) {
        // Code here
        int maxR = 0;
        int maxC = 0;

        for(int[] a: stones){
            maxR = Math.max(maxR, a[0]);
            maxC = Math.max(maxC, a[1]);
        }

        DisjointSet ds = new DisjointSet(maxR +maxC+1);
        // HashMap<Integer,Integer> hm = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        for(int[] a: stones){
            int nodeR = a[0];
            int nodeC = maxR+ a[1]+1;

            ds.unionBySize(nodeR, nodeC);
            s.add(ds.findUPar(nodeC));
            s.add(ds.findUPar(nodeR));

            // hm.put(nodeR, 1);
            // hm.put(nodeC, 1);
        }

    

        int count =0;
        for(int a : s){
            if(ds.findUPar(a) == a)
            {
                count++;
            }
        }
        // for(Map.Entry<Integer,Integer> a : hm.entrySet()){
        //     if(ds.findUPar(a.getKey()) == a.getKey()){
        //         count++;
        //     }
        // }

        return n-count;

    }
}