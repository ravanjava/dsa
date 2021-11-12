package ram.dsa.misc;

public class RobotCircle {

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
    }
    static boolean isRobotBounded(String instructions) {
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        int x=0, y=0,indx=0;

        for(char c:instructions.toCharArray()){
            switch(c){
                case 'L': indx = (indx+3)%4; break;
                case 'R': indx = (indx+1)%4; break;
                case 'G': x = x+d[indx][0];
                    y = y+d[indx][1];
                    break;

            }
        }
        return (x==0 && y==0) || indx!=0;
    }
}
