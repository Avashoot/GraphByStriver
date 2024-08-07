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

public class NoOfIsland2 {
    static boolean isValid(int nr, int nc, int n, int m){
        if(nr>=0 && nr<n && nc>=0 && nc<m) return true;
        return false;
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        DisjointSet ds = new DisjointSet(rows*cols);
        List<Integer> ans = new ArrayList<>();
        int[][] visited = new int[rows][cols];
       
        int count =0;
        int[][] directions = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        for(int[] arr: operators){
            int r= arr[0];
            int c= arr[1];
            if(visited[r][c] ==1){ 
                ans.add(count);
                continue;
            }
            visited[r][c] =1;
            count++;

            for(int[] a: directions){
                int nr = r+a[0];
                int nc = c+a[1];
                if(isValid(nr, nc, rows, cols)){
                    if(visited[nr][nc] == 1){
                        int index = (r*cols + c);
                        int adjIndex = (nr*cols +nc);
                        if(ds.findUPar(index) != ds.findUPar(adjIndex)){
                            count--;
                            ds.unionByRank(index, adjIndex);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
