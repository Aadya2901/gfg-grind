class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Step 1: Build graph and reverse graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        int[] outdegree = new int[V];

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
            outdegree[u]++;
        }

        // Step 2: Queue for all terminal nodes (outdegree = 0)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        // Step 3: BFS to find all safe nodes
        boolean[] safe = new boolean[V];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;  // terminal or leads to terminal

            for (int nei : reverseGraph.get(node)) {
                outdegree[nei]--;
                if (outdegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // Step 4: Collect and sort safe nodes
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) result.add(i);
        }

        return result;  // Already in increasing order due to node numbering
    }
}