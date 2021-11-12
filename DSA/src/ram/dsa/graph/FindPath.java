package ram.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class FindPath {

    public static void main(String[] args) {
        int[][] graph = new int[3][3];
        boolean[] visited = new boolean[3];
        init(graph,visited);
        add(graph, 0, 1);
        add(graph, 1, 2);
        add(graph, 2, 0);

        System.out.println(Arrays.deepToString(graph));
        int start=0; int end=2;
        try {
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i] && i==start) {
                    LinkedList<Integer> path = new LinkedList<>();
                    dfs(graph, start, visited,path,end);
                    System.out.println(path.toString());
                    if(path.getFirst()==start && path.getLast()==end){
                        System.out.println("Path Found");
                    }else{
                        System.out.println("No Path");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int[][] g, int s, boolean[] visited,LinkedList<Integer> path,int end) {
        path.add(s);
        if(s==end){
              return;
        }
        visited[s] = true;

        for (int i = 0; i < g.length; i++) {
            if (g[s][i] == 1 && !visited[i]) {
                dfs(g, i, visited,path,end);
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
