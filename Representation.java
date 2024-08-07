import java.util.ArrayList;

public class Representation {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        int n =5;
        // add n+1 arrayList
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());
        // edge 1-3
        graph.get(1).add(3);
        graph.get(3).add(1);

        // edge 1-2
        graph.get(1).add(2);
        graph.get(2).add(1);

        // edge 2-4
        graph.get(2).add(4);
        graph.get(4).add(2);

        //edge 2-5
        graph.get(2).add(5);
        graph.get(5).add(2);

        //edge 3-4
        graph.get(3).add(4);
        graph.get(4).add(3);

        //edge 4-5
        graph.get(4).add(5);
        graph.get(5).add(4);


        System.out.println(graph);


    }
}