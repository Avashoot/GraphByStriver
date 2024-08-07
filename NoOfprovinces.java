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
public class NoOfprovinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);

        for(int i =0; i< V; i++){
            for(int j=0; j<V ; j++){
                if(adj.get(i).get(j) == 1){
                    ds.unionByRank(i, j);
                }
            }
        }

        int count=0;
        for(int i=0; i< V; i++){
            if(ds.parent.get(i) == i){
                count++;
            }
        }
        return count;
    }
}
