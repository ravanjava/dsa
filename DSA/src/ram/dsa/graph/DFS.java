package ram.dsa.graph;

import java.util.Arrays;

public class DFS {

    public static void main(String[] args) {
        int[][] graph = new int[4][4];
        boolean[] visited = new boolean[4];
        init(graph,visited);
        add(graph, 0, 1);
        add(graph, 3, 2);
        System.out.println(Arrays.deepToString(graph));
        try {
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i]) {
                    dfs(graph, i, visited);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int[][] g, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print("->" + s);
        for (int i = 0; i < g.length; i++) {
            if (g[s][i] == 1 && !visited[i]) {
                dfs(g, i, visited);
            }
        }
    }

    private static void init(int[][] graph,boolean[] visited){
        for (int[] row : graph)
            Arrays.fill(row, 0);
        Arrays.fill(visited, false);
    }

    private static void add(int[][] graph, int s, int e) {
        graph[s][e] = 1;
        graph[e][s] = 1;
    }
}
