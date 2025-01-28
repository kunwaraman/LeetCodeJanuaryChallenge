import java.util.*;

public class MinimumNumberOfFishInAgrid {
    int direct[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxfish=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    maxfish=Math.max(maxfish,bfs(grid,i,j));
                }
            }
        }
        return maxfish;
    }
    public int bfs(int[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});

        int fishtake=grid[i][j];
        grid[i][j]=0;
        while(!queue.isEmpty()){
            int[] cell = queue.remove();
            i=cell[0];
            j=cell[1];
            for(int dir[]:direct){
                int newi=i+dir[0];
                int newj=j+dir[1];
                if(newi>=0 && newi<m && newj>=0 && newj<n && grid[newi][newj]>0){
                    queue.add(new int[]{newi,newj});
                    fishtake+=grid[newi][newj];
                    grid[newi][newj]=0;

                }

            }
        }
        return fishtake;
    }
}
