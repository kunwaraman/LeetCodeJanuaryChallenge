// ps: https://leetcode.com/problems/count-servers-that-communicate/

public class CountServerThatCanCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    boolean canComu=false;
                    for(int col=0;col<n;col++){
                        if(grid[i][col]==1 && col!=j){
                            canComu=true;
                            break;
                        }
                    }
                    if(canComu==true){
                        count++;
                    }else{
                        for(int row=0;row<m;row++){
                            if(grid[row][j]==1 && row!=i){
                                canComu=true;
                                break;
                            }
                        }
                        if(canComu==true){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
