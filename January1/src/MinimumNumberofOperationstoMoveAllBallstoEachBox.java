// ps: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
// brute force accepted
//  time complexity o(n^2)
// space complexity o(n)
public class MinimumNumberofOperationstoMoveAllBallstoEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                for(int j=0;j<n;j++){
                    ans[j]+=Math.abs(i-j);
                }
            }
        }
        return ans;
    }
}
