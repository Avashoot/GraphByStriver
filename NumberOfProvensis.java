import java.util.ArrayList;

public class NumberOfProvensis {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjLis = new ArrayList<>();
        for(int i =0; i<V; i++){
            adjLis.add(new ArrayList<>());
        }
        for(int i =0; i< V; i++){
            for(int j =0; j< V; j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    adjLis.get(i).add(j);
                    adjLis.get(j).add(i);

                }
            }
        }

        int[] visited = new int[V];
        int count = 0;
        for(int i =0; i< V; i++){
            if(visited[i] != 1){
                count ++;
                dfsg(i, adjLis, visited);
            }
        }
        return count;
    }

    public static void dfsg(int a, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[a]=1;
        for(int ele : adj.get(a)){
            if(visited[ele] != 1){
                dfsg(ele, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        String str = "Hello, world!";
        char ch = 'l';
    
        int index = str.lastIndexOf(ch);
        String s = str.substring(index);

        if (index == -1) {
            System.out.println("Character '" + ch + "' not found!");
        } else {
            System.out.println(index);
            System.out.println(s);
        }
    }
}
