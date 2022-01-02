package datastructures.unionfind;

public class UnionFind {

    // The number of elements in this UF
    private int size;

    //Used to track the sizes of each of the components
    private int[] sz;

    // id[i] points to the parent of i. If id[i] = i then i is a root node.
    private int[] id;

    //Tracks the number of components in the union find.
    private int numComponents;

    public UnionFind(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");

        this.size = size;
        sz = new int[size];
        id = new int[size];

        for (int i = 0; i < size; i++) {
            // Link each node to itself;
            id[i] = i;
            //Each component is initially of size 1;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        // Find the root of the component set.
        while (root != id[root]) {
            root = id[root];
        }
        //Compress the path leading back to the root.
        // Doing this operation is called "path compression"
        // and is what gives us amortized constant time complexity.

        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int componentSize(int p) {
        return sz[find(p)];
    }

    public int size() {
        return size;
    }

    public int components() {
        return numComponents;
    }

    public void unify(int p, int q) {

        int root1 = find(p);
        int root2 = find(q);

        //These elements are already in the same group.
        if (root1 == root2) return;

        //Merge two components/sets together.
        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1];
            id[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root2;
        }

        numComponents--;
    }
}
