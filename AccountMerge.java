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


public class AccountMerge {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // code here
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0; i< n; i++){
            for(int j=1; j< accounts.get(i).size(); j++){
                String mail =accounts.get(i).get(j);
                if(! hm.containsKey(mail)){
                    hm.put(mail,i);
                }
                else{
                    int u = hm.get(mail);
                    int v = i;
                    ds.unionByRank(u, v);
                }
            }
        }

        @SuppressWarnings("unchecked")
        ArrayList<String>[] mergeEmail = new ArrayList[n];
        for(int i=0; i<n; i++){
            mergeEmail[i] = new ArrayList<String>();
        }

        for(Map.Entry<String, Integer> a : hm.entrySet()){
            String mail = a.getKey();
            int node = ds.findUPar(a.getValue());
            mergeEmail[node].add(mail);
        }

        List<List<String>> ans =new ArrayList<>();

        for(int i =0; i< n; i++){
            if(mergeEmail[i].size()==0)continue;
            Collections.sort(mergeEmail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String a: mergeEmail[i]){
                temp.add(a);
            }
            ans.add(temp);
        }

        return ans;

    }
}
