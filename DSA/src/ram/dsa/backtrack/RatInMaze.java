package ram.dsa.backtrack;

public class RatInMaze {

    static  int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,1,1,0},{0,0,0,1,0},{0,1,1,1,0},{1,0,1,1,1}};
        //int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int [] start = {0,4};
        int [] dest = {4,4};
        System.out.println(hasPath(maze,start,dest));
    }

    static boolean hasPath(int[][] maze, int[] start, int[] destination) {
         return dfs(start[0],start[1],destination,maze,new boolean[maze.length][maze.length]);
        //return dfs(maze, new boolean[maze.length][maze.length], start, destination);
    }

    static boolean dfs(int i, int j, int[] dest,int[][] maze,boolean[][] visited){

        if(visited[i][j]) // check visited
            return false;

        if(i==dest[0]  && j == dest[1]){ //base condition
            return true;
        }

        visited[i][j] = true; // mark visited

        boolean result=false;

        for (int[] move : moves) { // traverse in sll directions
            int x = i + move[0];
            int y = j + move[1];
            while ( 0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
                x += move[0];
                y += move[1];
            }
            result = result || dfs(x-move[0],y-move[1],dest,maze,visited);
        }

        return result;
    }



    static boolean checkPath(int i, int j, int n,int[][] maze){
        return (0<=i && i<n && 0<=j && j<n && maze[i][j]==0);
    }
}
