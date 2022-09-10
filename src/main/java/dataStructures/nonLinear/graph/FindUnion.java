package dataStructures.nonLinear.graph;

public class FindUnion {

    private final int[] ranks;
    private final int[] parents;
    private final int size;

    public FindUnion(int size) {
        this.size = size;
        ranks = new int[size];
        parents = new int[size];
    }

    public int findParent(int node) {
        if (node == parents[node])
            return node;

        return parents[node] = findParent(parents[node]); // Also make Path Compression
    }

    public void union(int v, int u) {
        // we can use same variables
        v = findParent(v);
        u = findParent(u);

        // we need to check on Rank Values
        if (ranks[v] > ranks[u]) {
            parents[u] = v;
        } else if (ranks[u] > ranks[v]) {
            parents[v] = u;
        } else {
            parents[u] = v;
            ranks[v]++;
            // OR parents[v] = u; ranks[u]++;
        }

    }


}
