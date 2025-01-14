import java.util.*;
public class FindThePrefixCommonArrayOfTwoArrays {

    // brute force accepted
    //tme complexity o(n^3)
    // space complexity o(1) // we not consider result as a space
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<=i;j++){
                for(int k=0;k<=i;k++){
                    if(A[j]==B[k]){
                        count++;
                    }
                }
            }
            res[i]=count;
        }
        return res;
    }


    // optimised uing hashmap
    // time complexity o(n)
    // space complexity o(n)
    public int[] findThePrefixCommonArray1(int[] A, int[] B) {
        int n = A.length;
        int ans[] = new int[n];
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            if(map.get(A[i])==2){
                count++;
            }
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            if(map.get(B[i])==2){
                count++;
            }
            ans[i]=count;
        }
        return ans;

    }
}
