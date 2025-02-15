// ps: https://leetcode.com/problems/trapping-rain-water-ii/
import java.util.*;
// time complexity o(m*n)*log(m*n)
// space complexity o(m*n)
public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean vis[][] = new boolean[m][n];
        for(int row=0;row<m;row++){
            pq.add(new int[]{heightMap[row][0],row,0});
            vis[row][0]=true;
            pq.add(new int[]{heightMap[row][n-1],row,n-1});
            vis[row][n-1]=true;
        }
        for(int col=0;col<n;col++){
            pq.add(new int[]{heightMap[0][col],0,col});
            vis[0][col]=true;
            pq.add(new int[]{heightMap[m-1][col],m-1,col});
            vis[m-1][col]=true;
        }
        int water=0;
        int direc[][]= {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while(!pq.isEmpty()){
            int[] cell = pq.remove();
            int height = cell[0];
            int i = cell[1];
            int j = cell[2];
            for (int[] dir : direc) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !vis[i_][j_]) {
                    water += Math.max(height - heightMap[i_][j_], 0);
                    pq.add(new int[]{Math.max(height, heightMap[i_][j_]), i_, j_});
                    vis[i_][j_] = true;
                }
            }
        }
        return water;
    }

}
