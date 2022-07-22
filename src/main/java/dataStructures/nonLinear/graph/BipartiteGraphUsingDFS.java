package dataStructures.nonLinear.graph;

import java.util.ArrayList;
import java.util.List;

public class BipartiteGraphUsingDFS {

    private static boolean isBipartite(List<List<Integer>> adjacencyList, int v){
        Color[] colors = new Color[v+1];
        for (int i = 1; i <= v; i++) {
            if(!isBipartite(adjacencyList,i,colors))
                return false;
        }
        return true;
    }



        private static boolean isBipartite(List<List<Integer>> adjacencyList, int node, Color[] colors){
        if(colors[node] == null)
            colors[node] = Color.READ;

        for (int adjacencyNode : adjacencyList.get(node)){
            if(colors[adjacencyNode] == null) { // That's mean it's not visiting
                colors[adjacencyNode] = colors[node] == Color.READ ? Color.BLACK : Color.READ;
                if(!isBipartite(adjacencyList,adjacencyNode,colors))
                    return false;
            }else if(colors[adjacencyNode] == colors[node])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int nodes = 11;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= nodes; i++)
            adjacencyList.add(i, new ArrayList<>());

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(2).add(4);
        adjacencyList.get(4).add(2);

        adjacencyList.get(3).add(5);
        adjacencyList.get(5).add(3);

        adjacencyList.get(5).add(10);
        adjacencyList.get(10).add(5);
        adjacencyList.get(5).add(6);
        adjacencyList.get(6).add(5);

        adjacencyList.get(6).add(7);
        adjacencyList.get(7).add(6);

        adjacencyList.get(10).add(9);
        adjacencyList.get(9).add(10);

        adjacencyList.get(6).add(7);
        adjacencyList.get(7).add(6);

        adjacencyList.get(9).add(8);
        adjacencyList.get(8).add(9);

        adjacencyList.get(8).add(11);
        adjacencyList.get(11).add(8);


        System.out.println(isBipartite(adjacencyList,nodes));
    }
}
