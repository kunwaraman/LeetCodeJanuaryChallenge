import java.util.*;

public class FirstCompletelyPaintedRowOrColumn {
    //  Time Complexity: O((m*n) * s*(m+n)) , where s = arr.size() which is (m*n)
    // space complexity: O(m*n)
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // brute force
        int m = mat.length;
        int n = mat[0].length;
        int k= arr.length;
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=mat[i][j];
                map.put(val,new int[]{i,j});
            }
        }
        for(int i=0;i<k;i++){
            int val=arr[i];
            int cord[] = map.get(val);
            int row=cord[0];
            int col=cord[1];
            mat[row][col]*=-1; // paint

            if(crp(mat,row)||ccp(mat,col)){
                return i;
            }
        }
        return -1;
    }
    public boolean crp(int[][]matrix,int row){
        for(int col=0;col<matrix[0].length;col++){
            if(matrix[row][col]>0){
                return false;
            }
        }
        return true;
    }
    public boolean ccp(int matrix[][],int col){
        for(int row=0;row<matrix.length;row++){
            if(matrix[row][col]>0){
                return false;
            }
        }
        return true;
    }

    public int firstCompleteIndexBetterApproach(int[] arr, int[][] mat) {
        //time complexity O(m*n)
        // space complexity O(m*n)
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int minindex=Integer.MAX_VALUE;
        // for check each row one by one
        for(int row=0;row<m;row++){
            int lastidx=Integer.MIN_VALUE; // last index in arr when this row will completely painted
            for(int col=0;col<n;col++){
                int val=mat[row][col];
                int idx=map.get(val);
                lastidx=Math.max(lastidx,idx);
            }
            minindex=Math.min(minindex,lastidx);
        }
        // for check each column one by one
        for(int col=0;col<n;col++){
            int lastidx=Integer.MIN_VALUE; //last index in arr when colwill be completely painted
            for(int row=0;row<m;row++){
                int val=mat[row][col];
                int idx=map.get(val);
                lastidx=Math.max(lastidx,idx);
            }
            minindex=Math.min(minindex,lastidx);
        }
        return minindex;

    }



}
