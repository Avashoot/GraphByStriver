import java.util.*;

public class AlieanDictonary {
    public static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++)adj.add(new ArrayList<>());

        for(int i =0; i< N-1; i++){
            int f = dict[i].length();
            int s = dict[i+1].length();
            for(int j =0; j<Math.min(s, f); j++){
                if(dict[i].charAt(j) != dict[i+1].charAt(j)){
                    adj.get(dict[i].charAt(j)-97).add(dict[i+1].charAt(j)-97);
                    break;
                }
            }
        }

        System.out.println(adj);

        int[] indegree = new int[K];
        Queue<Integer> q = new LinkedList<>();
        for(ArrayList<Integer> arr: adj){
            for(int a: arr)
            {
                indegree[a]++;
            }
        }

        for(int i =0; i<K; i++){
            if(indegree[i] ==0){
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.remove();
            sb.append((char)(node+97));
            for(int a: adj.get(node))
            {
                indegree[a]--;
                if(indegree[a] == 0){
                    q.add(a);
                }
            }
        }

        String s = sb.toString();
        return s;
        
    }

    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};

        System.out.println(findOrder(dict, N, K));
        System.out.println((char)9);

    }

     
}
