import java.util.*;

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    //find ultimate parent
    public int findUPar(int node){
        if(node != parent.get(node)){
            parent.set(node,findUPar(parent.get(node)));
        }
        return parent.get(node);
    }

    //union by size
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v)return ;
        else if(size.get(ulp_v)> size.get(ulp_u)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
public class MakeLargeIsland {

    static boolean isValid(int nr, int nc, int n){
        if(nr>=0 && nr<n && nc >= 0 && nc < n) return true;
        return false;
    }
    public int MaxConnection(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[][] directions = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };

        //step 1
        for(int r =0; r<n; r++){
            for(int c =0; c<n; c++){
                if(grid[r][c] ==0) continue;

                for(int[] d: directions){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if(isValid(nr, nc, n)){
                        if(grid[nr][nc] == 1){
                            int index = r*n+c;
                            int newIndex = nr*n+nc;
                            ds.unionBySize(index, newIndex);
                        }
                    }

                }
            }
        }

        //step 2
        int mx = 0;
        for(int r =0; r<n; r++){
            for(int c =0; c<n; c++){
                if(grid[r][c]==1) continue;
                HashSet<Integer> components = new HashSet<>();
                for(int[] d : directions){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if(isValid(nr, nc, n)){
                        if(grid[nr][nc] == 1){
                            int newIndex = nr*n+nc;
                            components.add(ds.findUPar(newIndex));
                        }
                    }
                }

                int sizeTotal =0;
                for(int p: components){
                    sizeTotal += ds.size.get(p);
                }
                mx = Math.max(mx,sizeTotal +1);
            }
        } 

        for(int cellNo =0; cellNo< n*n; cellNo++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }

        return mx;
    }
}
