package ram.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    /*
       ## Traverse thru graph using DFS and mark visited vertex to '0' and count the disjoint sets
     */
    public static void main(String[] args) {
        int[][] graph = new int[4][4];
        init(graph);
        System.out.println(Arrays.deepToString(graph));
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(graph[i][j]==1){
                    count++; // Count islands
                    dfs(graph, i,j);
                }
            }
        }
        System.out.println("count: " + count);
    }

    private static void dfs(int[][] g, int r,int c) {

        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] == 0) {
            return;
        }
        g[r][c] = 0; // Mark as visited
        dfs(g,r-1,c);
        dfs(g,r+1,c);
        dfs(g,r,c-1);
        dfs(g,r,c+1);

    }

    static int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here
        int m = binaryMatrix.length;
        int n = binaryMatrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int ans = 0;

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                if (visited[j][k]) {
                    continue;
                }
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{j, k});
                visited[j][k] = true;
                while (!q.isEmpty()) {
                    int[] now = q.remove();
                    for (int i = 0; i < 4; i++) {
                        int newx = now[0] + dx[i];
                        int newy = now[1] + dy[i];
                        if (newx >= 0 && newx < m && newy >= 0 && newy < n && !visited[newx][newy] && binaryMatrix[newx][newy] == 1) {
                            q.add(new int[]{newx, newy});
                            visited[newx][newy] = true;
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }

    private static void init(int[][] graph) {
        for (int[] row : graph)
            Arrays.fill(row, 0);

        add(graph, 0, 0);
        add(graph, 0, 2);
        add(graph, 1, 2);
        add(graph, 1, 3);
        add(graph, 2, 0);
        add(graph, 2, 2);
        add(graph, 3, 0);
        add(graph, 3, 3);
    }

    private static void add(int[][] graph, int s, int e) {
        graph[s][e] = 1;
    }
}
