import java.util.*;

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0; i<=n; i++){
            parent.add(i);
            rank.add(0);
        }
    }

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
        }else if(rank.get(ulp_u)< rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else{
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);
        }
    }
}

public class ConnectingTheGraph {
    public int Solve(int n, int[][] edge) {
        // Code here
        int countextra =0;
        DisjointSet ds = new DisjointSet(n);

        for(int[] arr : edge){
            int u = arr[0];
            int v = arr[1];

            if(ds.findUPar(u) == ds.findUPar(v)) countextra++;
            else ds.unionByRank(u, v);
        }

        int countComponent = 0;
        for(int i=0; i< n; i++){
            if(ds.parent.get(i) == i) countComponent++;
        }

        if(countComponent-1 <= countextra) return countComponent-1;
        return -1;
    }
}
