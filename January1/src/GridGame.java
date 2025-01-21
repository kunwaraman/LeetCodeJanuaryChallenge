// time complexity o(n);
// space complexity o(1)
// ps: https://leetcode.com/problems/grid-game/
/*
the main key is rpbot 1 is try to miniminize the robot 2 points
robot 2 will play optimally in every strategy that r1 takes r2 will try to choose best with whatever he has got
 */

public class GridGame {
    public long gridGame(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long firstrowsum=0;
        for(int val:grid[0]){ // o(col)
            firstrowsum+=val;
        }
        long secondrowsum=0;
        long minimisedsumr2=Long.MAX_VALUE;
        for(int rc=0;rc<n;rc++){ // o(col)
            // robot 1 took this strategy
            firstrowsum-=grid[0][rc];
            // robot 2 try to do best after robot1 has taken the above strategy
            long bestofrobot2=Math.max(firstrowsum,secondrowsum);
            minimisedsumr2=Math.min(minimisedsumr2,bestofrobot2);
            secondrowsum+=grid[1][rc];


        }
        return minimisedsumr2;

    }
}
